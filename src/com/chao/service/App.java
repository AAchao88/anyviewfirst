package com.chao.service;

import com.chao.controler.menu.Menu;
import com.chao.controler.verify.Verify;

/**
 * 入口类
 */
public class App {
    //程序入口
    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    public void start(){
        //new 所需对象
        Menu menu = new Menu();
        Verify verify = new Verify();
        while(true){
            menu.menuMain();
            int item = verify.MenuItemVerify(1,4);
            switch(item){
                case 1:
                    Login login = new Login();

                    break;
                case 2:break;
                case 3:break;
                case 4:break;
                default:
            }
        }
    }

    /**
     * 已注册的用户登录首页
     */
    public void HomeUser(){
        Menu menu = new Menu();
        Verify verify = new Verify();

        menu.menuHomeUser();
        int item = verify.MenuItemVerify(1,9);
        switch(item){
            case 1:break;
            case 2:break;
            case 3:break;
            case 4:break;
            case 5:break;
            case 6:break;
            case 7:break;
            case 8:break;
            case 9:break;
            default:
        }
    }

    /**
     * 未注册游客首页
     */
    public void HomeTourist(){
        Menu menu = new Menu();
        Verify verify = new Verify();



    }
}
