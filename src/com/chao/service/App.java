package com.chao.service;

import com.chao.controler.menu.Menu;
import com.chao.controler.verify.Verify;

/**
 * 入口类
 */
public class App {

    //public static Integer userId = null;

    //程序入口
    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    /**
     * 程序开启后第一个界面
     */
    public void start(){
        //new 所需对象
        Menu menu = new Menu();
        Verify verify = new Verify();
        while(true){
            menu.menuMain();
            int item = verify.MenuItemVerify(1,4);
            switch(item){
                case 1: Login login = new Login(); login.input(); break;
                case 2: Register register = new Register(); register.input(); break;
                case 3: //游客   break;
                case 4: System.exit(0); break;
                default:
            }
        }
    }

    /**
     * 已注册的用户登录首页
     */
    public void HomeUser(){
        //先new所需的对象
        Menu menu = new Menu();
        Verify verify = new Verify();
        Home home = new Home();

        while(true){
            menu.menuHomeUser();
            int item = verify.MenuItemVerify(1,9);
            switch(item){
                case 1:home.mine();break;
                case 2:home.square();break;
                case 3:home.team();break;
                case 4:home.favorite();break;
                case 5:home.personal_Knowledge_base();break;
                case 6:home.create_knowledge_base();break;
                case 7:home.cooperate_knowledge_base();break;
                case 8:home.recycleBin();break;
                case 9:System.exit(0);break;
                default:
            }
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
