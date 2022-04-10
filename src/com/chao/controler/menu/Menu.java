package com.chao.controler.menu;

public class Menu {

        public void menuMain(){
            System.out.println("----------------------欢迎进入类语雀-----------------------");
            System.out.println("-                        1.登录                          -");
            System.out.println("-                        2.注册                          -");
            System.out.println("-                        3.游客身份进入                   -");
            System.out.println("-                        4.退出                          -");
            System.out.println("----------------------------------------------------------");
        }
        public void menuHomeUser(){
            System.out.println("----------------------欢迎进入类语雀-----------------------");
            System.out.println("-                        1.我的                          -");
            System.out.println("-                        2.广场                          -");
            System.out.println("-                        3.团队                          -");
            System.out.println("-                        4.收藏                          -");
            System.out.println("-                        5.个人知识库                     -");
            System.out.println("-                        6.新建知识库                     -");
            System.out.println("-                        7.协作知识库                     -");
            System.out.println("-                        8.回收站                        -");
            System.out.println("-                        9.退出                          -");
            System.out.println("----------------------------------------------------------");

        }


        public void menuModifyMine(){

            System.out.println("----------------------欢迎进入<我的>-----------------------");
            System.out.println("-                      1.查看个人信息                     -");
            System.out.println("-                      2.修改用户名                       -");
            System.out.println("-                      3.重置密码                         -");
            System.out.println("-                      4.修改性别                         -");
            System.out.println("-                      5.修改联系电话                     -");
            System.out.println("-                      6.修改电子邮箱                     -");
            System.out.println("-                      7.返回                            -");
            System.out.println("----------------------------------------------------------");
        }

        public void menuModeifyArticle(){
            System.out.println("        1.修改文档题目");
            System.out.println("        2.修改文档标签");
            System.out.println("        3.修改文档内容");
            System.out.println("        4.回复评论");
            System.out.println("        5.显示文档的相关信息（点赞数、收藏数、评论数、修改时间等）");
            System.out.println("        6.导出文档到本地");
            System.out.println("        7.删除文档\n");
        }

        public void menuTeam1(){
            System.out.println("\n1.创建团队");
            System.out.println("2.管理的团队");
            System.out.println("3.加入的团队");
            System.out.println("4.加入团队");
            System.out.println("5.返回\n");
        }

        public void menuManagedTeam(){
            System.out.println("\n1.查看协作知识库");
            System.out.println("2.管理成员");
            System.out.println("3.邀请成员");
            System.out.println("4.新建协作知识库\n");
        }

        public void menuModifyPermission(){
            System.out.println("\n1.修改为只读权限");
            System.out.println("2.修改为可编辑权限");
            System.out.println("3.修改我可评论权限");
            System.out.println("4.踢出该成员");
            System.out.println("5.返回\n");
        }

        public void menuInviteMembers(){
            System.out.println("\n1.获取团队只读权限的邀请码");
            System.out.println("2.获取团队可编辑权限的邀请码");
            System.out.println("3.获取团队可评论权限的邀请码\n");
        }

        public void menuSquare(){
            System.out.println("1.点赞该文档");
            System.out.println("2.收藏该文档");
            System.out.println("3.评论该文档");
            System.out.println("4.返回\n");
        }


}

