package com.chao.controler.verify;

import com.chao.dao.Select;
import com.chao.po.Users;

import java.util.Scanner;

public class Verify {
    //验证菜单项的方法
    public int menuItemVerify(int min, int max){
        //创建Scanner输入对象
        Scanner scanner = new Scanner(System.in);
        //正则表达式
        String regex = "[1-9]{1,}";
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
    public Boolean usernameVerify_login(String s,Users users){
            //在数据库中查看是否有此用户名
        Select select = new Select();
            if(select.selectUsers(s,3,users)){
                return true;
            }else{
                System.out.println("输入的用户名有误，请检查！\n");
                return false;
            }
    }

    //验证密码的方法
    public Boolean passwordVerify_login(String s,Users users){
        String regex = "[0-9a-zA-Z]{6,40}";
        Select select = new Select();
        if(s.matches(regex)){
            //在数据库中查看密码是否正确
            if(select.selectUsers(s,4,users)){
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

    public Boolean usernameVerify_register(String s,Users users){
        Select select = new Select();
        //在数据库中查找，是否存在
        if(select.selectUsers(s,3,users)){
            System.out.println("该用户名已经存在，请更换一个用户名!");
            return false;
        }else{
           // users.setUsername(s);
            return true;
        }
    }
    public Boolean passwordVerify_register(String s){
        String regex = "[0-9a-zA-Z]{6,40}";
        Users users = new Users();
        if(s.matches(regex)){
            return true;
        }else{
            System.out.println("输入的密码不符合格式，请重新输入！");
            return false;
        }
    }

    public int sexVerify(){
        Scanner scanner = new Scanner(System.in);
        String regex1 = "[1]{1}";
        String regex2 = "[2]{1}";
        System.out.println("1.男   2.女 ");
        while(true){
            System.out.println("请根据性别输入数字：");
            String input = scanner.nextLine();
            if(input.matches(regex1)){
                return 1;
            }else{
                return 2;
            }
        }
    }
}
