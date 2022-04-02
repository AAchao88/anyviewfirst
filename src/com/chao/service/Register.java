package com.chao.service;

import com.chao.controler.verify.Verify;
import com.chao.dao.Insert;
import com.chao.po.Users;
import com.chao.service.OperateImp.Input;

import java.util.Scanner;

public class Register implements Input {

    @Override
    public void input() {
        //先实例化所需对象
        Scanner scanner = new Scanner(System.in);
        Verify verify = new Verify();
        Insert insert = new Insert();
        Users users = new Users();
        while(true){
            System.out.println("请输入您的用户名：");
            String input = scanner.nextLine();
            if(verify.usernameVerify_register(input)){
                break;
            }
        }
        while(true){
            System.out.println("请输入您的密码：\t（密码由数字或大小字母组成，且至少6位）");
            String input = scanner.nextLine();
            if(verify.passwordVerify_register(input)){
                break;
            }
        }
      //用户输入性别
       int flag = verify.sexVerify();
        if(flag == 1){
            users.setSex("男");
        }else {
            users.setSex("女");
        }

        //用户输入电话
        String regex_telephone = "[0-9]{6,20}";
        System.out.println("请输入您的联系电话：");
        String input1 = scanner.nextLine();
        while(true){
            if(input1.matches(regex_telephone)){
                users.setTelephone(Integer.parseInt(input1));
                break;
            }
            System.out.println("输入有误，请重新输入联系电话。");
            input1 = scanner.nextLine();
        }

        //用户输入电子邮箱
        String regex_email = "([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}";
        System.out.println("请输入您的电子邮箱：");
        String input2 = scanner.nextLine();
        while(true){
            if(input2.matches(regex_email)){
                users.setEmail(input2);
                insert.insertUsers(users);
                System.out.println("注册成功！");
                return;
            }
            System.out.println("输入有误，请重新输入电子邮箱。");
            input2 = scanner.nextLine();
        }
    }
}
