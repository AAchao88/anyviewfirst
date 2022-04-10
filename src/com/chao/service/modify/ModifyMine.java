package com.chao.service.modify;

import com.chao.controler.verify.Verify;
import com.chao.dao.Select;
import com.chao.dao.Update;
import com.chao.po.Users;
import com.chao.service.OperateImp.ModifyMineImp;

import java.util.Scanner;

public class ModifyMine implements ModifyMineImp {

    @Override
    public void modifyUsername(Users users) {
        //先实例化所需对象
        Scanner scanner = new Scanner(System.in);
        Update update = new Update();
        Verify verify = new Verify();

        while(true){
            System.out.println("请输入您新的用户名：");
            String input = scanner.nextLine();
            if(verify.usernameVerify_register(input,users)){
                //存进数据库
                users.setUsername(input);
                update.updateUsers(users,1);
                System.out.println("修改成功！");
                return ;
            }
        }
    }

    @Override
    public void modifyPassword(Users users) {
        //先实例化所需对象
        Scanner scanner = new Scanner(System.in);
        Verify verify = new Verify();
        Update update = new Update();
        Select select = new Select();
        System.out.println("请先输入原来的密码：");
        for (int i = 0; i < 5; i++) {
            String inputOld = scanner.nextLine();
            if(select.selectUsers(inputOld,4,users)){
                break;
            }else {
                if(i == 4){
                    return;
                }else {
                    System.out.println("密码错误！请重新输入，您还有"+(4-i)+"次机会。");
                }
            }
        }
        while(true){
            System.out.println("请输入您新的密码：");
            String inputNew = scanner.nextLine();
            if(verify.passwordVerify_register(inputNew)){
                //存进数据库
                users.setPassword(inputNew);
                update.updateUsers(users,2);
                System.out.println("修改成功！");
                return ;
            }
        }
    }

    @Override
    public void modifySex(Users users) {
        Verify verify = new Verify();
        //Select select = new Select();
        Update update = new Update();
        int flag = verify.sexVerify();
        if(flag == 1){
            users.setSex("男");
            update.updateUsers(users,3);
        }
        if(flag == 2){
            users.setSex("女");
            update.updateUsers(users,3);
        }

    }

    @Override
    public void modifyTelephone(Users users) {
        //Verify verify = new Verify();
        Update update = new Update();
        Scanner scanner = new Scanner(System.in);
        String regex = "[0-9]{6,20}";
        System.out.println("请输入您的联系电话：");
        String input = scanner.nextLine();
        while(true){
            if(input.matches(regex)){
                users.setTelephone(input);
                update.updateUsers(users,4);
                return;
            }
            System.out.println("输入有误，请重新输入联系电话。");
            input = scanner.nextLine();
        }
    }

    @Override
    public void modifyEmail(Users users) {
        Update update = new Update();
        Scanner scanner = new Scanner(System.in);
        String regex = "([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}";
        System.out.println("请输入您的电子邮箱：");
        String input = scanner.nextLine();
        while(true){
            if(input.matches(regex)){
                users.setEmail(input);
                update.updateUsers(users,5);
                return;
            }
            System.out.println("输入有误，请重新输入电子邮箱。");
            input = scanner.nextLine();
        }
    }
}
