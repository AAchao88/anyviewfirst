package com.chao.service;

import com.chao.controler.helper.*;
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
        HelperSquare helperSquare = new HelperSquare();
        Menu menu = new Menu();
        Verify verify = new Verify();
        Select select = new Select();
        Update update = new Update();
        Insert insert = new Insert();
        HelperArticle helperArticle = new HelperArticle();

        String comment = null;

        Article articleChecked = helperSquare.showShared();
        System.out.println("\n");
        helperSquare.showInformation(articleChecked);
        menu.menuSquare();
        int flag = verify.menuItemVerify(1,4);
        if(flag == 4){
            return;
        }
        switch (flag){
            case 1:{
                if(select.selectRepeat(users,articleChecked,flag)){
                    insert.insertInformation(users,articleChecked,comment,flag);
                    update.updateInformation(articleChecked,flag);
                    break;
                }else {
                    System.out.println("您已经点赞过该文档，不可重复！");
                    break;
                }
            }
            case 2:{
                if(select.selectRepeat(users,articleChecked,flag)){
                    insert.insertInformation(users,articleChecked,comment,flag);
                    update.updateInformation(articleChecked,flag);
                    break;
                }else {
                    System.out.println("您已经收藏过文档！");
                    break;
                }
            }
            case 3:{
                comment = helperArticle.helperWrite();
                if(comment == null){
                    break;
                }else {
                    insert.insertInformation(users,articleChecked,comment,flag);
                    update.updateInformation(articleChecked,flag);
                    break;
                }
            }
            default:
        }

    }

    @Override
    public void team(Users users) {
        Menu menu = new Menu();
        Verify verify = new Verify();
        Scanner scanner = new Scanner(System.in);
        Insert insert = new Insert();
        Select select = new Select();
        HelperTeam helperTeam = new HelperTeam();
        Boolean judge = true;
        while (judge){
            menu.menuTeam1();
            int serialNumber = verify.menuItemVerify(1,5);
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
                        System.out.println("您尚未创建过团队！");
                        break;
                    }
                    for(i = 0;listMaTeam.size()>i;i++){
                        System.out.println((i+1)+"."+listMaTeam.get(i).getTeam_name());
                    }
                    System.out.println("请输入序号选择团队：");
                    int serialNum = verify.menuItemVerify(1,i);

                    menu.menuManagedTeam();
                    int flag = verify.menuItemVerify(1,4);

                    switch (flag){
                        case 1:{
                            LinkedList<Member> listMembers = select.selectMember(listMaTeam.get(serialNum-1));
                            if(listMembers.isEmpty() == true){
                                System.out.println("尚未创建协作知识库！");
                                break;
                            }
                            for(i = 0;listMembers.size()>i;i++){
                                System.out.println((i+1)+"."+listMembers.get(i).getKnowledgebase_name());
                            }
                            System.out.println("请输入序号选择协作知识库：");
                            int serialNum2 = verify.menuItemVerify(1,i);

                            System.out.println("1.新建文章   2.编辑已有文章   3.返回");
                            int judge2 = verify.menuItemVerify(1,3);
                            if(judge2 == 3){
                                break;
                            }
                            if(judge2 == 1){
                                newArticle(users,listMembers.get(serialNum2-1).getKnowledgebase_id());
                            }else {
                                editArticle(users,listMembers.get(serialNum2-1).getKnowledgebase_id());
                            }
                            break;
                        }
                        case 2:{
                            helperTeam.modifyPermission(listMaTeam.get(serialNum-1));
                            break;
                        }
                        case 3:{
                            menu.menuInviteMembers();
                            int permission = verify.menuItemVerify(1,3);
                            System.out.println("邀请码："+select.selectCode(listMaTeam.get(serialNum-1),permission));;
                            break;
                        }
                        case 4:{
                            insert.insertKnowledgebaseInTeam(create_knowledge_base(users,2),listMaTeam.get(serialNum-1));
                            break;
                        }
                        default:
                    }
                    break;
                }
                case 3:{
                    LinkedList<Team> listJoTeam = new LinkedList<>();
                    listJoTeam = select.selectJoinTeam(users);
                    int i = 0;
                    if(listJoTeam.isEmpty() == true){
                        System.out.println("尚未加入团队，请先加入团队！");
                        break;
                    }
                    for(i = 0;listJoTeam.size()>i;i++){
                        System.out.println((i+1)+"."+listJoTeam.get(i).getTeam_name());
                    }
                    System.out.println("请输入序号选择团队：");
                    int serialNum = verify.menuItemVerify(1,i);
                    LinkedList<Member> listMembers = select.selectMember(listJoTeam.get(serialNum-1));

                    int permission = select.selectPermission(listJoTeam.get(serialNum-1),users);
                    //获取用户关于选定团队的权限
                    if(listMembers.isEmpty() == true){
                        System.out.println("团队还没有成员，请先邀请成员！");
                        break;
                    }
                    for(i = 0;listMembers.size()>i;i++){
                        System.out.println((i+1)+"."+listMembers.get(i).getKnowledgebase_name());
                    }
                    System.out.println("请输入序号选择协作知识库：");
                    int serialNum2 = verify.menuItemVerify(1,i);
                    helperTeam.joinedTeam(users,listMembers.get(serialNum2-1).getKnowledgebase_id(),permission);
                    break;
                }
                case 4:{
                    System.out.println("请输入所要加入团队的邀请码：");
                    String code = scanner.nextLine();
                    Member member = select.selectIvCode(code,users);
                    if(member == null){
                        System.out.println("邀请码错误！");
                        break;
                    }else {
                        member.setMember_name(users.getUsername());
                        insert.insertJoinTeam(member);
                        break;
                    }
                }
                case 5:{
                    judge = false;
                    break;
                }
                default:
            }
        }
    }



    @Override
    public void favorite(Users users) {
        Select select = new Select();
        Verify verify = new Verify();
        Delete delete = new Delete();
        HelperSquare helperSquare = new HelperSquare();
        LinkedList<Article> listFavorite = select.selectFavorite(users);
        if(listFavorite.isEmpty()){
            System.out.println("尚未收藏过文档，请先收藏文档！");
            return;
        }
        int i = 0;
        for(i = 0;listFavorite.size()>i;i++){
            System.out.println((i+1)+"."+listFavorite.get(i).getTitle());
            System.out.println("\t\t标签-->"+listFavorite.get(i).getTag());

        }
        System.out.println("请输入序号选择要查看的文档：");
        int serialNum = verify.menuItemVerify(1,i);
        System.out.println("1.查看文档\n2.删除文档\n3.返回");
        int flag = verify.menuItemVerify(1,3);
        if(flag == 3)return;
        if(flag == 1){
            System.out.println("\t\t"+listFavorite.get(serialNum-1).getTitle());
            System.out.println(listFavorite.get(serialNum-1).getContent());
            helperSquare.showInformation(listFavorite.get(serialNum-1));
        }else {
            delete.deleteFavorite(listFavorite.get(serialNum-1));
        }

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
            if(storeKnowledgeName.isEmpty()){
                System.out.println("暂无知识库，请先创建知识库！");
                return;
            }
            int i = 0;
            for(i=0;storeKnowledgeName.size()>i;i++){
                System.out.println((i+1)+"."+storeKnowledgeName.get(i));
            }
            System.out.println("\n请正确输入想进入的知识库的序号：");
            int serialNumber = verify.menuItemVerify(1,i);
            knowledgeBase.setId(select.selectIdByName(storeKnowledgeName.get(serialNumber-1)));
            System.out.println("1.新建文章   2.编辑已有文章   3.返回");
            int judge = verify.menuItemVerify(1,3);
            if(judge == 3){
                return;
            }
            if(judge == 1){
                newArticle(users,knowledgeBase.getId());
            }else {
                editArticle(users,knowledgeBase.getId());
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
        HelperComment helperComment = new HelperComment();
        HelperSquare helperSquare = new HelperSquare();
       // LinkedList<Article> listArticle = select.selectArticle(kb_id);
        LinkedList<Article> listArticle = new LinkedList<>();
        listArticle.addAll(select.selectArticle(kb_id));
        if(listArticle.isEmpty()){
            System.out.println("没有文档，请先新建文档！");
            return;
        }
        int i = 0;
        //循环因子
        for(i = 0;listArticle.size()>i;i++){
            System.out.println((i+1)+"."+listArticle.get(i).getTitle());
            System.out.println("\t标签："+listArticle.get(i).getTag()+"\n");
        }

        System.out.println("请输入序号选择文档：");
        int serialNum = verify.menuItemVerify(1,i);
        //返回的判断变量
        Boolean judge = true;
        while (judge){
            menu.menuModeifyArticle();
            int flag = verify.menuItemVerify(1,8);
            switch (flag){
                case 1:{
                    System.out.println("请输入新的文档标题：");
                    String inputTitle = scanner.nextLine();
                    listArticle.get(serialNum-1).setTitle(inputTitle);
                    break;
                }
                case 2:{
                    System.out.println("请输入新的文档标签：");
                    String inputTag = scanner.nextLine();
                    listArticle.get(serialNum-1).setTag(inputTag);
                    break;
                }
                case 3:{
                    listArticle.get(serialNum-1).setContent(helperArticle.helperEdit(listArticle.get(serialNum-1).getContent(),1));
                    listArticle.get(serialNum-1).setUpdate_time(new Date(System.currentTimeMillis()));
                    break;
                }
                case 4:{
                    helperComment.replyComment(listArticle.get(serialNum-1));
                    break;
                }
                case 5:{
                    //  helperArticle.printInformation(listArticle.get(serialNum-1));break;
                    helperSquare.showInformation(listArticle.get(serialNum-1));
                    break;
                }
                case 6:{
                    helperArticle.exportLocal(listArticle.get(serialNum-1));
                    break;
                }
                case 7:{
                    delete.deleteArticleFake(listArticle.get(serialNum-1));
                    break;
                }
                case 8:{
                    judge = false;
                    break;
                }
                default:
            }
            if(flag>=1 && flag<=3){
                update.updateArticle(listArticle.get(serialNum-1),flag);
            }

        }
    }

    /**
     *   新建知识库
     *   获取知识库id，将其赋到文章信息
     *   要求输入知识库的信息（分类为个人还是协作，name,tag,）
     *   联系数据库
     */
    @Override
    public KnowledgeBase create_knowledge_base(Users users,int flag) {
        KnowledgeBase knowledgeBase = new KnowledgeBase();
        Scanner scanner = new Scanner(System.in);
        Insert insert = new Insert();
        Verify verify = new Verify();
        Select select = new Select();

        knowledgeBase.setCreate_user_id(users.getId());
        System.out.println("请输入知识库的名称：\t（注意不超过20个字）");
        String inputName = scanner.nextLine();
        knowledgeBase.setKnowledgebase_name(inputName);
        System.out.println("请输入知识库的标签：\t（注意不超过30个字）");
        String inputTag = scanner.nextLine();
        knowledgeBase.setTag(inputTag);
        if(flag == 1){
            System.out.println("请输入数字选择知识库的类别：");
            System.out.println("1.个人知识库     2.协作知识库   ");
            int judge = verify.menuItemVerify(1,2);
            if(judge == 1){
                knowledgeBase.setCategory("个人知识库");
            }else {
                knowledgeBase.setCategory("协作知识库");
            }
        }else {
            knowledgeBase.setCategory("协作知识库");
        }
        knowledgeBase.setCreate_time(new Date(System.currentTimeMillis()));
        insert.insertKnowledgeBase(knowledgeBase);
        knowledgeBase.setId(select.selectIdByName(knowledgeBase.getKnowledgebase_name()));
        return knowledgeBase;
    }


    @Override
    public void recycleBin(Users users) {
        Select select = new Select();
        Verify verify = new Verify();
        Update update = new Update();
        Delete delete = new Delete();
        HelperArticle helperArticle = new HelperArticle();
        LinkedList<Article> listRecycleBin = select.selectRecycleBin(users);
        LinkedList<Article> listRecovery = new LinkedList<>();
        if (listRecycleBin.isEmpty()){
            System.out.println("没有删除过的文档！");
            return;
        }
        int i = 0,j=0;
        //循环因子
        Long now = System.currentTimeMillis();
        Date nowTime = new Date(now);
        //获取当前时间
        for(i = 0,j=0; listRecycleBin.size()>i;i++){
            if(helperArticle.computationDayTime(listRecycleBin.get(i).getDeleteTime(),nowTime) <= 7){
                listRecovery.add(listRecycleBin.get(i));
                j++;
                System.out.println(j+"."+listRecovery.get(j-1).getTitle());
            }else {
                delete.deleteArticleTrue(listRecycleBin.get(i));
            }
        }
        System.out.println("请输入要复原的文档的序号：");
        int serialNumber = verify.menuItemVerify(1,j);
        update.updateArticle(listRecovery.get(serialNumber-1),5);

    }

    @Override
    public void newArticle(Users users,Integer kb_id) {
        Insert insert = new Insert();
        Article article = new Article();
        HelperArticle helperArticle = new HelperArticle();
        Scanner scanner = new Scanner(System.in);
        Verify verify = new Verify();

        article.setAuthor_id(users.getId());
        article.setKnowledgebase_id(kb_id);
        System.out.println("请输入文章的题目：\t（注意不超过30个字）");
        String inputName = scanner.nextLine();
        article.setTitle(inputName);
        System.out.println("请输入文章的标签：\t（注意不超过20个字）");
        String inputTag = scanner.nextLine();
        article.setTag(inputTag);
        article.setContent(helperArticle.helperWrite());
        System.out.println("1.共享文档    2.非共享文档    ");
        System.out.println("请输入数字设置对文章共享的管理：（共享文档即可在广场中找到的文档）");
        article.setShared(verify.menuItemVerify(1,2));
        article.setCreate_time(new Date(System.currentTimeMillis()));
        insert.insertArticle(article);
    }

}
