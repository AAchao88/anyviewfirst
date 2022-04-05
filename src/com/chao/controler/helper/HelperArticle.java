package com.chao.controler.helper;

import com.chao.po.Article;

import java.io.*;
import java.util.Scanner;

public class HelperArticle {

    public String helperWrite(){
        //使用 BufferedReader 在控制台读取字符
        // 使用 System.in 创建 BufferedReader
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br =new BufferedReader(ir);
        String returnValue = null;
        String str = null;
        StringBuilder sb = new StringBuilder();
        System.out.println("请输入文本：");
        System.out.println("注意 <换行>输入'退出并保存'或'退出不保存'以结束编辑。");
        try{
            do {
                try {
                    str = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(str.equals("退出并保存")){
                    returnValue =  String.valueOf(sb);
                    break;
                }
                if(str.equals("退出不保存")){
                    break;
                }else {
                    sb.append(str+"\n");
                }
            }while (true);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(br != null){
                    br.close();
                }
                if(ir != null){
                    ir.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return returnValue;
        }
    }


    public String helperEdit(String original){
        StringBuilder sb = new StringBuilder();
        sb.append(original);
        System.out.println(original);
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br =new BufferedReader(ir);

        String returnValue = original;
        String str = null;
        System.out.println("\n注意 <换行>输入'退出并保存'或'退出不保存'以结束编辑。");
        try{
            do {
                try {
                    str = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(str.equals("退出并保存")){
                    returnValue = String.valueOf(sb);
                    break;
                }
                if(str.equals("退出不保存")){
                    break;
                }else {
                    sb.append(str+"\n");
                }
            }while (true);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(br != null){
                    br.close();
                }
                if(ir != null){
                    ir.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return returnValue;
        }
    }

    public void printInformation(Article article){
        System.out.println("文档当前的点赞数为："+article.getLike());
        System.out.println("文档当前的收藏数为："+article.getFavorite());
        System.out.println("文档当前的评论数为："+article.getLike());
        if(article.getShared() == 1){
            System.out.println("文档当前为：共享文档");
        }else {
            System.out.println("文档当前为：非共享文档");
        }
    }

    public void exportLocal(Article article){
        Scanner scanner = new Scanner(System.in);
        FileWriter fw = null;
        BufferedWriter bw = null;
        try{
            System.out.println("请输入导出文档的路径和名字（无需输入后缀名，默认为text）：");
            System.out.println("注意以单斜杠或双反斜杠分开。如：d:/第一篇  或  d:\\第一篇 ");
            String fileName = scanner.nextLine();
            fw = new FileWriter(fileName+".txt");
            bw = new BufferedWriter(fw);
            bw.write(article.getContent());
            bw.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(bw != null){
                    bw.close();
                }
                if(fw != null){
                    fw.close();
                }
                System.out.println("导出成功！");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
