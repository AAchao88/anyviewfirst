package com.chao.controler.helper;

import com.chao.po.Article;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class HelperArticle implements HelperArticleImp{

    /**
     * 新建文档时，输入文本
     * @return
     */
    @Override
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
        }
        return returnValue;
    }


    /**
     * flag ==1为编辑文章  ，flag ==2为回复评论
     * @param original
     * @param flag
     * @return
     */
    @Override
    public String helperEdit(String original,int flag){
        StringBuilder sb = new StringBuilder();
        sb.append(original);
        System.out.println(original);
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br =new BufferedReader(ir);

        String returnValue = original;
        String str = null;
        System.out.println("\n注意 <换行>输入'退出并保存'或'退出不保存'以结束编辑。");
        if(flag == 2){
            sb.append("\n作者回复：\n");
        }
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
        }
        return returnValue;
    }

    /**
     * 用于打印文档的有关信息
     * @param article
     */
    @Override
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

    /**
     * 把文档导出到本地
     * @param article
     */
    @Override
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

    /**
     * 计算删除的文档是否已经超过7天
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public Long computationDayTime(Date startTime, Date endTime) {
        final long ND = 86400000;
        try {
            long diff = endTime.getTime() - startTime.getTime();
            long day = diff / ND;
            return day;
        } catch (Exception e) {
            return null;
        }
    }

}
