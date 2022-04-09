package com.chao.service;

import com.chao.controler.helper.HelperSquare;
import com.chao.controler.menu.Menu;
import com.chao.controler.verify.Verify;
import com.chao.po.Article;
import com.chao.po.Users;

/**
 * 入口类
 */
public class App {

    /**
     * 程序入口
     */
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
        Home home = new Home();
        while(true){
            menu.menuMain();
            int item = verify.menuItemVerify(1,4);
            switch(item){
                case 1: Login login = new Login(); login.input(); break;
                case 2: Register register = new Register(); register.input(); break;
                case 3: homeTourist();break;
                case 4: System.exit(0); break;
                default:
            }
        }
    }

    /**
     * 已注册的用户登录首页
     */
    public void HomeUser(Users users){
        //先new所需的对象
        Menu menu = new Menu();
        Verify verify = new Verify();
        Home home = new Home();

        while(true){
            menu.menuHomeUser();
            int item = verify.menuItemVerify(1,9);
            switch(item){
                case 1:home.mine(users);break;
                case 2:home.square(users);break;
                case 3:home.team(users);break;
                case 4:home.favorite(users);break;
                case 5:home.Knowledge_base(users,item);break;
                case 6:home.create_knowledge_base(users,1);break;
                case 7:home.Knowledge_base(users,item);break;
                case 8:home.recycleBin(users);break;
                case 9:System.exit(0);break;
                default:
            }
        }
    }

    /**
     * 未注册游客首页
     */
    public void homeTourist(){
        HelperSquare helperSquare = new HelperSquare();
        Article articleChecked = helperSquare.showShared();
        System.out.println("\n\n");
        helperSquare.showInformation(articleChecked);
    }
}
