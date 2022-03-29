package com.chao.service;

import com.chao.controler.verify.Verify;

import java.util.Scanner;

/**
 * @author xryz
 * 登录实现类
 */
public class Login implements Input {


    @Override
    public void input() {
        //先实例化所需对象
        Scanner scanner = new Scanner(System.in);
        Verify verify = new Verify();

        //String input = null;
        int i;
        //循环因子
        for( i=0;i<5;i++){
            System.out.println("请输入正确的用户名：");
            String input = scanner.nextLine();
            if(verify.usernameVerify(input)){
                break;
            }
        }
        if(i==5){
            System.out.println("如果尚未注册，请先注册！");
            return ;
        }

        for( i=0;i<5;i++){
            System.out.println("请输入正确的密码：");
            String input = scanner.nextLine();
            if(verify.passwordVerify(input)){
                break;
            }
        }
        if(i==5){
            System.out.println("如果尚未注册，请先注册！");
            return ;
        }else{
            //登录成功
            App app = new App();
            app.HomeUser();

        }
    }
}
