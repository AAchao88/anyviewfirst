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
                insert.insertUsers(users);
                break;
            }
        }
        while(true){
            System.out.println("请输入您的密码：\t（密码由数字或大小字母组成，且至少6位）");
            String input = scanner.nextLine();
            if(verify.passwordVerify_register(input)){
                insert.insertUsers(users);
                System.out.println("注册成功！");
                return ;
            }
        }
    }
}
