package com.chao.service.modify;

import com.chao.controler.verify.Verify;
import com.chao.dao.Update;
import com.chao.po.Users;
import com.chao.service.OperateImp.ModifyMineImp;

import java.util.Scanner;

public class ModifyMine implements ModifyMineImp {

    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public void modifyUsername(Users users) {
        //先实例化所需对象
        Scanner scanner = new Scanner(System.in);
        Update update = new Update();
        Verify verify = new Verify();
        setFlag(1);

//        while(true){
//            System.out.println("请输入您当前的用户名：");
//            String input = scanner.nextLine();
//            if(verify.usernameVerify_register(input)){
//                break;
//            }
//        }
        while(true){
            System.out.println("请输入您新的用户名：");
            String input = scanner.nextLine();
            if(verify.usernameVerify_register(input)){
                //存进数据库
                //users.setUsername(input);
                update.updateUsers(users);
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
        flag = 2;

//        while(true){
//            System.out.println("请输入您当前的密码：");
//            String input = scanner.nextLine();
//            if(verify.passwordVerify_register(input)){
//                break;
//            }
//        }
        while(true){
            System.out.println("请输入您新的密码：");
            String input = scanner.nextLine();
            if(verify.passwordVerify_register(input)){
                //存进数据库
               // users.setPassword(input);
                update.updateUsers(users);
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
        flag = 3;
        int flag = verify.sexVerify();
        if(flag == 1){
            users.setSex("男");
            update.updateUsers(users);
        }
        if(flag == 2){
            users.setSex("女");
            update.updateUsers(users);
        }

    }

    @Override
    public void modifyTelephone(Users users) {
        //Verify verify = new Verify();
        Update update = new Update();
        flag = 4;
        Scanner scanner = new Scanner(System.in);
        String regex = "[0-9]{6,20}";
        System.out.println("请输入您的联系电话：");
        String input = scanner.nextLine();
        while(true){
            if(input.matches(regex)){
                users.setTelephone(Integer.parseInt(input));
                update.updateUsers(users);
                return;
            }
            System.out.println("输入有误，请重新输入联系电话。");
            input = scanner.nextLine();
        }
    }

    @Override
    public void modifyEmail(Users users) {
        Update update = new Update();
        flag = 5;
        Scanner scanner = new Scanner(System.in);
        String regex = "([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}";
        System.out.println("请输入您的电子邮箱：");
        String input = scanner.nextLine();
        while(true){
            if(input.matches(regex)){
                users.setEmail(input);
                update.updateUsers(users);
                return;
            }
            System.out.println("输入有误，请重新输入电子邮箱。");
            input = scanner.nextLine();
        }
    }
}
