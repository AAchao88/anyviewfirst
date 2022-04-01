package com.chao.service.modify;

import com.chao.controler.verify.Verify;
import com.chao.dao.Select;
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
        flag = 2;

        while(true){
            System.out.println("请输入您当前的密码：");
            String input = scanner.nextLine();
            if(verify.passwordVerify_register(input)){
                break;
            }
        }
        while(true){
            System.out.println("请输入您新的密码：");
            String input = scanner.nextLine();
            if(verify.passwordVerify_register(input)){
                //存进数据库
                System.out.println("修改成功！");
                return ;
            }
        }
    }

    @Override
    public void modifySex(Users users) {
        Verify verify = new Verify();
        Select select = new Select();
        flag = 3;
        if()

    }

    @Override
    public void modifyTelephone(Users users) {

        flag = 4;
    }

    @Override
    public void modifyEmail(Users users) {

        flag = 5;
    }
}
