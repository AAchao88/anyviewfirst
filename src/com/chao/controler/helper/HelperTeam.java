package com.chao.controler.helper;

import com.chao.controler.verify.Verify;
import com.chao.dao.Select;
import com.chao.dao.Update;
import com.chao.po.Article;
import com.chao.po.Member;
import com.chao.po.Team;
import com.chao.po.Users;

import java.util.LinkedList;

public class HelperTeam {

    public void joinedTeam(Users users, Integer kb_id,int permission) {
        Select select = new Select();
        //Menu menu = new Menu();
        Verify verify = new Verify();
        Update update = new Update();
        //Delete delete = new Delete();
       // Scanner scanner = new Scanner(System.in);
        HelperArticle helperArticle = new HelperArticle();
        LinkedList<Article> listArticle = select.selectArticle(kb_id);
        int i = 0;
        //循环因子
        for(Article article: listArticle){
            System.out.println((i+1)+"."+article);
            i++;
        }

        System.out.println("请输入序号选择文档：");
        int serialNum = verify.menuItemVerify(1,i-1);

//        menu.menuModeifyArticle();
//        int flag = verify.menuItemVerify(1,7);
        switch (permission){
            case 1:
                System.out.println(select.selectArticleContent(listArticle.get(i-1)).getTitle());
                System.out.println(select.selectArticleContent(listArticle.get(i-1)).getContent());
                helperArticle.printInformation(listArticle.get(serialNum));
                break;
            case 2:
                listArticle.get(serialNum).setContent(helperArticle.helperEdit(listArticle.get(serialNum).getContent()));
                break;
            case 3: listArticle.get(serialNum).setContent(helperArticle.helperEdit(listArticle.get(serialNum).getContent()));
                break;
            //加评论
            default:
        }
        if(permission == 2){
            update.updateArticle(listArticle.get(serialNum),3);
        }
        if(permission == 3){
            update.updateArticle(listArticle.get(serialNum),3);
            update.updateArticle(listArticle.get(serialNum),4);
        }
    }

    public void modifyPermission(Team team){
        Select select = new Select();
        Update update = new Update();
        Verify verify = new Verify();
        LinkedList<Member> listMember = select.selectMember(team);
        int i = 0;
        for(i = 0;!listMember.isEmpty();){
            if(listMember.get(i).getMember_id() != null){
                System.out.println((i+1)+"."+listMember.get(i).getMember_name());
                i++;
            }
        }
        System.out.println("请输入序号选择查看的成员：");
        int serialNum = verify.menuItemVerify(1,i);
        update.updatePermission(team,listMember.get(serialNum).getMember_permission());
    }



}
