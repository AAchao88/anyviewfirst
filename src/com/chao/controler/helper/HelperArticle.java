package com.chao.controler.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelperArticle {

    public String helperWrite(){
        //使用 BufferedReader 在控制台读取字符
        // 使用 System.in 创建 BufferedReader
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        StringBuilder sb = new StringBuilder();
        System.out.println("请输入文本：");
        System.out.println("注意 换行输入'退出'以结束编辑。");
        do {
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sb.append(str+"\n");
        }while (!str.equals("退出"));
        return  String.valueOf(sb);
    }
}
