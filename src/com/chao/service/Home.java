package com.chao.service;

import com.chao.controler.helper.HelperArticle;
import com.chao.controler.helper.HelperTeam;
import com.chao.controler.helper.IvCodeGenerator;
import com.chao.controler.menu.Menu;
import com.chao.controler.verify.Verify;
import com.chao.dao.Delete;
import com.chao.dao.Insert;
import com.chao.dao.Select;
import com.chao.dao.Update;
import com.chao.po.*;
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
        Select select = new Select();
        Verify verify = new Verify();

        LinkedList<Article> listShared = select.selectSharedArticle();

    }

    @Override
    public void team(Users users) {
        Menu menu = new Menu();
        Verify verify = new Verify();
        Scanner scanner = new Scanner(System.in);
        Insert insert = new Insert();
        Select select = new Select();
        HelperTeam helperTeam = new HelperTeam();
        menu.menuTeam1();
        int serialNumber = verify.menuItemVerify(1,4);

        switch (serialNumber){
            case 1:{
                IvCodeGenerator ivCodeGenerator = new IvCodeGenerator();
                System.out.println("请输入团队名称：");
                String input = scanner.nextLine();
                System.out.println("请任意输入一个正数: (系统将自动设置一个只读文档权限邀请码)");
                String code1 = ivCodeGenerator.inviCode(scanner.nextInt());
                System.out.println("请任意输入一个正数: (系统将自动设置一个评论文档权限邀请码)");
                String code2 = ivCodeGenerator.inviCode(scanner.nextInt());
                System.out.println("请任意输入一个正数: (系统将自动设置一个修改文档权限邀请码)");
                String code3 =ivCodeGenerator.inviCode(scanner.nextInt());
                Team team = new Team(users.getId(),input,code1,code2,code3);
                insert.insertTeam(team);
                break;
            }
            case 2:{
                LinkedList<Team> listMaTeam = new LinkedList<>();
                listMaTeam = select.selectManageTeam(users);
                int i = 0;
                if(listMaTeam.isEmpty() == true){
                    break;
                }
                for(i = 0;!listMaTeam.isEmpty();i++){
                    System.out.println((i+1)+"."+listMaTeam.get(i).getTeam_name());
                }
                System.out.println("请输入序号选择团队：");
                int serialNum = verify.menuItemVerify(1,i);

                menu.menuManagedTeam();
                int flag = verify.menuItemVerify(1,3);

                switch (flag){
                    case 1:{
                        LinkedList<Member> listMembers = select.selectMember(listMaTeam.get(i-1));
                        if(listMembers.isEmpty() == true){
                            break;
                        }
                        for(i = 0;!listMembers.isEmpty();i++){
                            System.out.println((i+1)+"."+listMembers.get(i).getKnowledgebase_name());
                        }
                        System.out.println("请输入序号选择协作知识库：");
                        int serialNum2 = verify.menuItemVerify(1,i);
                        editArticle(users,listMembers.get(i-1).getKnowledgebase_id());
                        break;
                    }
                    case 2:{
                        helperTeam.modifyPermission(listMaTeam.get(serialNum));break;
                    }
                    case 3:{
                        menu.menuInviteMembers();
                        int permission = verify.menuItemVerify(1,3);
                        select.selectCode(listMaTeam.get(serialNum),permission);
                        break;
                    }
                    default:
                }

            }
            case 3:{
                LinkedList<Team> listJoTeam = new LinkedList<>();
                listJoTeam = select.selectJoinTeam(users);
                int i = 0;
                if(listJoTeam.isEmpty() == true){
                    break;
                }
                for(i = 0;!listJoTeam.isEmpty();i++){
                    System.out.println((i+1)+"."+listJoTeam.get(i).getTeam_name());
                }
                System.out.println("请输入序号选择团队：");
                int serialNum = verify.menuItemVerify(1,i);
                LinkedList<Member> listMembers = select.selectMember(listJoTeam.get(i-1));

                int permission = select.selectPermission(listJoTeam.get(i-1),users);
                //获取用户关于选定团队的权限
                if(listMembers.isEmpty() == true){
                    break;
                }
                for(i = 0;!listMembers.isEmpty();i++){
                    System.out.println((i+1)+"."+listMembers.get(i).getKnowledgebase_name());
                }
                System.out.println("请输入序号选择协作知识库：");
                int serialNum2 = verify.menuItemVerify(1,i);
                helperTeam.joinedTeam(users,listMembers.get(serialNum2).getKnowledgebase_id(),permission);
                break;


            }
            case 4:{
                System.out.println("请输入所要加入团队的邀请码：");
                String code = scanner.nextLine();
                Member member = select.selectIvCode(code,users);
                if(member == null){
                    break;
                }else {
                    insert.insertJoinTeam(member);
                    break;
                }
            }
            default:
        }
    }



    @Override
    public void favorite(Users users) {

    }

    /**
     *   知识库
     *   获取知识库id，将其赋到文章信息
     *   可以输出、新建、编辑、tag标签、删除
     */
    @Override
    public void Knowledge_base(Users users, int item) {

        /**
         *
         * 通过user.id查询所有知识库,分为个人知识库和协作知识库
         */
        Select select = new Select();
        Verify verify = new Verify();
        Scanner scanner = new Scanner(System.in);
        KnowledgeBase knowledgeBase = new KnowledgeBase();
        LinkedList<String > storeKnowledgeName =  new LinkedList<>();
        storeKnowledgeName = select.selectKnowledgeBase(users.getId(),item);
        if(storeKnowledgeName == null){
            return;
        }
//        if(item == 5){
//
//        }
        int i = 0;
        for(i=0;!storeKnowledgeName.isEmpty();i++){
            System.out.println((i+1)+"."+storeKnowledgeName.get(i));
        }
        System.out.println("请正确输入想进入的知识库的序号：");
        int serialNumber = verify.menuItemVerify(1,i);
        knowledgeBase.setId(select.selectIdByName(storeKnowledgeName.get(serialNumber-1)));
        System.out.println("1.新建文章     2.编辑已有文章  ");
        if(verify.menuItemVerify(1,2) == 1){
            newArticle(users,knowledgeBase);
        }else {
            editArticle(users,knowledgeBase);
        }
    }

    @Override
    public void editArticle(Users users, Integer kb_id) {
        Select select = new Select();
        Menu menu = new Menu();
        Verify verify = new Verify();
        Update update = new Update();
        Delete delete = new Delete();
        Scanner scanner = new Scanner(System.in);
        HelperArticle helperArticle = new HelperArticle();
        LinkedList<Article> listArticle = select.selectArticle(kb_id);
        int i = 0;
        //循环因子
        for(Article article: listArticle){
            System.out.println((i+1)+"."+article);
            i++;
        }
//        System.out.println("请正确输入要编辑的文档的名字或id：");
//        Boolean judge = true;
//        //双重循环的判断退出变量
//        while(judge){
//            String input = scanner.nextLine();
//            for(i = 0;!listArticle.isEmpty();i++){
//                if(input.equals(listArticle.get(i).getTitle()) || Integer.parseInt(input) == listArticle.get(i).getId()){
//                    judge = false;
//                    break;
//                }
//            }
//            if(judge == true){
//                System.out.println("输入有误，请检查并重新输入。");
//            }
//        }
        System.out.println("请输入序号选择文档：");
        int serialNum = verify.menuItemVerify(1,i-1);

        menu.menuModeifyArticle();
        int flag = verify.menuItemVerify(1,7);
        switch (flag){
            case 1:
                System.out.println("请输入新的文档标题：");
                String inputTitle = scanner.nextLine();
                listArticle.get(serialNum).setTitle(inputTitle);break;
            case 2:System.out.println("请输入新的文档标签：");
                String inputTag = scanner.nextLine();
                listArticle.get(serialNum).setTitle(inputTag);break;
            case 3: listArticle.get(serialNum).setContent(helperArticle.helperEdit(listArticle.get(serialNum).getContent()));
                    break;
            case 4:break;//回复评论
            case 5:helperArticle.printInformation(listArticle.get(serialNum));break;
            case 6:helperArticle.exportLocal(listArticle.get(serialNum));break;
            case 7:delete.deleteArticle(listArticle.get(serialNum));break;
            default:
        }
        if(flag>=1 && flag<=4){
            update.updateArticle(listArticle.get(serialNum),flag);
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
    public void recycleBin(Users users) {
        Select select = new Select();
        Verify verify = new Verify();
        Update update = new Update();
        HelperArticle helperArticle = new HelperArticle();
        LinkedList<Article> listRecycleBin = select.selectRecycleBin(users);
        LinkedList<Article> listRecovery = new LinkedList<>();
        int i = 0,j=0;
        //循环因子
        Long now = System.currentTimeMillis();
        Date nowTime = new Date(now);
        //获取当前时间
        for(i = 0,j=0; !listRecycleBin.isEmpty();i++){
            if(helperArticle.computationDayTime(listRecycleBin.get(i).getDeleteTime(),nowTime) <= 7){
                listRecovery.add(listRecycleBin.get(i));
                j++;
                System.out.println(j+"."+listRecovery.get(j-1).getTitle());
            }
        }
        System.out.println("请输入要复原的文档的序号：");
        int serialNumber = verify.menuItemVerify(1,j);
        update.updateArticle(listRecovery.get(serialNumber-1),5);



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
