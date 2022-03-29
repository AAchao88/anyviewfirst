package com.chao.controler.verify;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

public class Verify {

    //验证菜单项的方法
    public int MenuItemVerify(int min,int max){
        //创建Scanner输入对象
        Scanner scanner = new Scanner(System.in);
        //正则表达式
        String regex = "[1-9]{1}";
        while(true){
            System.out.println("请输入正确的数字，最小是："+min+"\t"+"最大是："+max);
            String input = scanner.nextLine();
            if(input.matches(regex)){
                int inputNum = Integer.parseInt(input);
                if(inputNum >= min && inputNum <= max){
                    return inputNum;
                }else{
                    System.out.println("您的输入与菜单项不符，请重新输入！");
                }
            }else{
                System.out.println("输入数字错误，请检查！");
            }
        }
    }

    //验证用户名的方法
    public Boolean usernameVerify_login(String s){
       // String regex = "[0-9]{9}";
        //if(s.matches(regex)){
            //在数据库中查看是否有此用户名
            if(存在){
                return true;
            }else{
                System.out.println("输入的用户名有误，请检查！\n");
                return false;
            }
//        }else{
//            System.out.println("输入的用户名有误，请检查！\n");
//            return false;
//        }
    }

    //验证密码的方法
    public Boolean passwordVerify(String s){
        String regex = "[0-9a-zA-Z]{6,40}";
        if(s.matches(regex)){
            //在数据库中查看密码是否正确
            if(正确){
                return true;
            }else{
                System.out.println("密码输入错误！请检查。");
                return false;
            }
        }else{
            System.out.println("密码输入错误！请检查。");
            return false;
        }
    }

    public Boolean usernameVerify_register(String s){
        //在数据库中查找，是否存在
        if(存在){
            System.out.println("该用户名已经存在，请更换一个用户名");
            return false;
        }else{
            //调用写入函数，将用户名存进数据库
            return true;
        }
    }
    public Boolean passwordVerify_register(String s){
        String regex = "[0-9a-zA-Z]{6,40}";
        if(s.matches(regex)){
            return true;
        }else{
            System.out.println("输入的密码不符合格式，请重新输入！");
            return false;
        }
    }





}
