package com.chao.controler.helper;

import com.chao.controler.menu.Menu;
import com.chao.controler.verify.Verify;
import com.chao.dao.Delete;
import com.chao.dao.Select;
import com.chao.dao.Update;
import com.chao.po.Article;
import com.chao.po.Member;
import com.chao.po.Team;
import com.chao.po.Users;

import java.util.Date;
import java.util.LinkedList;

public class HelperTeam {

    /**
     * 查看加入的团队的方法，
     * 涉及到成员的权限
     * @param users
     * @param kb_id
     * @param permission
     */
    public void joinedTeam(Users users, Integer kb_id,int permission) {
        Select select = new Select();
        HelperComment helperComment = new HelperComment();
        Verify verify = new Verify();
        Update update = new Update();
        HelperArticle helperArticle = new HelperArticle();
        HelperComment helperComment1 = new HelperComment();

        LinkedList<Article> listArticle = select.selectArticle(kb_id);
        if(listArticle.isEmpty()){
            System.out.println("该协作知识库暂无文档！");
            return;
        }
        int i = 0;
        for(i = 0;listArticle.size()>i;i++){
            System.out.println((i+1)+"."+listArticle.get(i).getTitle());
        }

        System.out.println("请输入序号选择文档：");
        int serialNum = verify.menuItemVerify(1,i);

        Article article = select.selectArticleContent(listArticle.get(serialNum-1));
        System.out.println(article.getTitle());
        System.out.println(article.getContent());
        helperComment.showComment(listArticle.get(serialNum-1));
        helperArticle.printInformation(listArticle.get(serialNum-1));
        int judge = 2,judge1 = 2;
        switch (permission){
            case 1:{
                System.out.println("\n--->您在该团队只有只读权限，有问题请联系管理员。<---\n");
                break;
            }
            case 2:{
                System.out.println("\n--->您在该团队有可编辑权限，有问题请联系管理员。<---\n");
                System.out.println("1.修改文档    2.不修改文档");
                judge = verify.menuItemVerify(1,2);
                if (judge == 1){
                    listArticle.get(serialNum-1).setContent(helperArticle.helperEdit(listArticle.get(serialNum-1).getContent(),1));
                    listArticle.get(serialNum-1).setUpdate_time(new Date(System.currentTimeMillis()));
                }
                break;
            }
            case 3: {
                System.out.println("\n--->您在该团队有可回复评论权限，有问题请联系管理员。<---\n");
                System.out.println("1.修改文档    2.不修改文档");
                judge = verify.menuItemVerify(1,2);
                if (judge == 1){
                    listArticle.get(serialNum-1).setContent(helperArticle.helperEdit(listArticle.get(serialNum-1).getContent(),1));
                    listArticle.get(serialNum-1).setUpdate_time(new Date(System.currentTimeMillis()));
                }
                System.out.println("1.回复评论    2.不回复评论");
                judge1 = verify.menuItemVerify(1,2);
                if (judge1 == 1){
                    helperComment.replyComment(listArticle.get(serialNum-1));
                    //listArticle.get(serialNum-1).setUpdate_time(new Date(System.currentTimeMillis()));
                }
                break;
            }
            default:
        }
        if(permission == 2 && judge == 1){
            update.updateArticle(listArticle.get(serialNum-1),3);
        }
        if(permission == 3 && judge == 1){
            update.updateArticle(listArticle.get(serialNum-1),3);
        }
    }

    /**
     * 管理成员
     * @param team
     */
    public void modifyPermission(Team team){
        Select select = new Select();
        Update update = new Update();
        Verify verify = new Verify();
        Menu menu = new Menu();
        Delete delete = new Delete();
        LinkedList<Member> listMember = select.selectMember(team);
        if(listMember.isEmpty()){
            System.out.println("暂无成员，请先邀请成员！");
            return;
        }
        int i = 0;
        for(i = 0;listMember.size()>i;i++){
            System.out.println((i+1)+"."+listMember.get(i).getMember_name());
        }
        System.out.println("请输入序号选择要管理的成员：");
        int serialNum = verify.menuItemVerify(1,i);
        menu.menuModifyPermission();
        int flag = verify.menuItemVerify(1,5);
        if(flag == 5){
            return;
        }
        if(flag == 4){
            delete.deleteMember(listMember.get(serialNum-1));
        }else {
            update.updatePermission(listMember.get(serialNum-1),flag);
        }

    }

}
