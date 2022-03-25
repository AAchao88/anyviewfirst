package com.chao.www.controler.menu;

public class MenuOne implements NextStep {

        public void menuOne(){
            System.out.println("----------------------欢迎进入类语雀-----------------------");
            System.out.println("-                        1.登录                          -");
            System.out.println("-                        2.注册                          -");
            System.out.println("-                        3.游客身份进入                   -");
            System.out.println("-                        4.退出                          -");
            System.out.println("----------------------------------------------------------");

        }

        @Override
        public void nextStep() {
            System.out.println("\n请按选项输入您的下一步操作：\n");
        }
}

