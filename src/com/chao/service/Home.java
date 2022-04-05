package com.chao.service;

import com.chao.controler.helper.HelperArticle;
import com.chao.controler.menu.Menu;
import com.chao.controler.verify.Verify;
import com.chao.dao.Delete;
import com.chao.dao.Insert;
import com.chao.dao.Select;
import com.chao.dao.Update;
import com.chao.po.Article;
import com.chao.po.KnowledgeBase;
import com.chao.po.Users;
import com.chao.service.OperateImp.HomeImp;
import com.chao.service.modify.ModifyMine;

import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Home implements HomeImp {

    @Override
    public void mine(Users users) {
        /**
         *        我的
         *先显示所有用户信息和修改界面
         */
        Menu menu = new Menu();
        Verify verify = new Verify();
        ModifyMine modifyMine = new ModifyMine();
        Select select = new Select();

        while(true){
            menu.menuModifyMine();
            int item = verify.menuItemVerify(1,7);
            switch(item){
                case 1: select.selectUsers(users.getId(),1,users);break;
                case 2: modifyMine.modifyUsername(users); break;
                case 3: modifyMine.modifyPassword(users); break;
                case 4: modifyMine.modifySex(users); break;
                case 5: modifyMine.modifyTelephone(users);break;
                case 6: modifyMine.modifyEmail(users);break;
                case 7: return;
                default:
            }
        }
    }

    @Override
    public void square(Users users) {

    }

    @Override
    public void team(Users users) {

    }

    @Override
    public void favorite(Users users) {

    }

    /**
     *   个人知识库
     *   获取知识库id，将其赋到文章信息
     *   可以输出、新建、编辑、tag标签、删除
     */
    @Override
    public void personal_Knowledge_base(Users users) {
        /**
         *
         * 通过user.id查询所有个人知识库
         */
        Select select = new Select();
        Verify verify = new Verify();
        Scanner scanner = new Scanner(System.in);
        KnowledgeBase knowledgeBase = new KnowledgeBase();

        String[] storeKnowledgeName = new String[20];

        storeKnowledgeName = select.selectKnowledgeBase(users,1,storeKnowledgeName);
        int i;
        for( i = 0;storeKnowledgeName[i] != null;i++){
            System.out.println(i+"."+storeKnowledgeName[i]);
        }
        //System.out.println("当前共有"+(i-1)+"个个人知识库\n");
        Boolean judge = true;
        while(judge){
            System.out.println("请正确输入想进入的知识库名字：");
            for( i = 0;storeKnowledgeName[i] != null;i++){
                String input = scanner.nextLine();
                if(input.equals(storeKnowledgeName[i])){
                    knowledgeBase.setId(select.selectIdByName(input));
                    judge = false;
                    break;
                }else {
                    System.out.println("输入错误，请检查并重新输入！");
                }
            }
        }
        System.out.println("1.新建文章     2.编辑已有文章  ");
        if(verify.menuItemVerify(1,2) == 1){
            newArticle(users,knowledgeBase);
        }else {

        }


    }

    @Override
    public void editArticle(Users users, KnowledgeBase knowledgeBase) {
        Select select = new Select();
        Menu menu = new Menu();
        Verify verify = new Verify();
        Update update = new Update();
        Delete delete = new Delete();
        Scanner scanner = new Scanner(System.in);
        HelperArticle helperArticle = new HelperArticle();
        LinkedList<Article> listArticle = select.selectArticle(knowledgeBase);
        int i = 0;
        //循环因子
        for(Article article: listArticle){
            System.out.println("i."+article);
            i++;
        }
        System.out.println("请正确输入要编辑的文档的名字或id：");
        Boolean judge = true;
        //双重循环的判断退出变量
        while(judge){
            String input = scanner.nextLine();
            for(i = 0;!listArticle.isEmpty();i++){
                if(input.equals(listArticle.get(i).getTitle()) || Integer.parseInt(input) == listArticle.get(i).getId()){
                    judge = false;
                    break;
                }
            }
            if(judge == true){
                System.out.println("输入有误，请检查并重新输入。");
            }
        }
        menu.menuModeifyArticle();
        int flag = verify.menuItemVerify(1,7);
        switch (flag){
            case 1:
                System.out.println("请输入新的文档标题：");
                String inputTitle = scanner.nextLine();
                listArticle.get(i).setTitle(inputTitle);break;
            case 2:System.out.println("请输入新的文档标签：");
                String inputTag = scanner.nextLine();
                listArticle.get(i).setTitle(inputTag);break;
            case 3: listArticle.get(i).setContent(helperArticle.helperEdit(listArticle.get(i).getContent()));
                    break;
            case 4:break;//回复评论
            case 5:helperArticle.printInformation(listArticle.get(i));break;
            case 6:helperArticle.exportLocal(listArticle.get(i));break;
            case 7:delete.deleteArticle(listArticle.get(i));break;
            default:
        }
        if(flag>=1 && flag<=4){
            update.updateArticle(listArticle.get(i),flag);
        }

    }

    /**
     *   新建知识库
     *   获取知识库id，将其赋到文章信息
     *   要求输入知识库的信息（分类为个人还是协作，name,tag,）
     *   联系数据库
     */
    @Override
    public void create_knowledge_base(Users users) {
        KnowledgeBase knowledgeBase = new KnowledgeBase();
        Scanner scanner = new Scanner(System.in);
        Insert insert = new Insert();

        knowledgeBase.setCreate_user_id(users.getId());
        System.out.println("请输入知识库的名称：\t（注意不超过20个字）");
        String inputName = scanner.nextLine();
        knowledgeBase.setKnowledgebase_name(inputName);
        System.out.println("请输入知识库的标签：\t（注意不超过30个字）");
        String inputTag = scanner.nextLine();
        knowledgeBase.setTag(inputTag);

        System.out.println("请输入数字选择知识库的类别：");
        System.out.println("1.个人知识库     2.协作知识库   ");
        String regex1 = "[1]{1}";
        String regex2 = "[2]{1}";
        while(true){
            String input = scanner.nextLine();
            if(input.matches(regex1)){
                knowledgeBase.setCategory("个人知识库");break;
            }
            if(input.matches(regex2)){
                knowledgeBase.setCategory("协作知识库");break;
            }
            System.out.println("输入有误，请重新输入。");
        }

        knowledgeBase.setCreate_time(new Date(System.currentTimeMillis()));
        insert.insertKnowledgeBase(knowledgeBase);
        return;
    }

    @Override
    public void cooperate_knowledge_base(Users users) {

    }

    @Override
    public void recycleBin(Users users) {

    }

    @Override
    public void newArticle(Users users,KnowledgeBase knowledgeBase) {
        Insert insert = new Insert();
        Article article = new Article();
        HelperArticle helperArticle = new HelperArticle();
        Scanner scanner = new Scanner(System.in);
        Verify verify = new Verify();

        article.setAuthor_id(users.getId());
        article.setKnowledgebase_id(knowledgeBase.getId());
        System.out.println("请输入文章的题目：\t（注意不超过30个字）");
        String inputName = scanner.nextLine();
        article.setTitle(inputName);
        System.out.println("请输入文章的标签：\t（注意不超过20个字）");
        String inputTag = scanner.nextLine();
        article.setTag(inputTag);

        article.setContent(helperArticle.helperWrite());
        System.out.println("1.共享文档    2.非共享文档    3.暂不设置");
        System.out.println("请输入数字设置对文章共享的管理：");
        article.setShared(verify.menuItemVerify(1,3));
        article.setCreate_time(new Date(System.currentTimeMillis()));
        insert.insertArticle(article);
    }




}
