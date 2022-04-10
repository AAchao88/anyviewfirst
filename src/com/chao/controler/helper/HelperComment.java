package com.chao.controler.helper;

import com.chao.controler.verify.Verify;
import com.chao.dao.Select;
import com.chao.dao.Update;
import com.chao.po.Article;

import java.util.LinkedList;

public class HelperComment {
    public void replyComment(Article article){
        Select select = new Select();
        Verify verify = new Verify();
        HelperArticle helperArticle = new HelperArticle();
        Update update = new Update();
        LinkedList<String> listComment = select.selectComment(article);
        if(listComment.isEmpty()){
            System.out.println("该文档暂无评论！");
            return;
        }
        int k = 0;
        for(k = 0;listComment.size()>k;k++){
            System.out.println((k+1)+"."+listComment.get(k));
        }
        System.out.println("请输入序号选择评论：");
        int serial = verify.menuItemVerify(1,k);
        String comment = helperArticle.helperEdit(listComment.get(serial-1),2);
        update.updateComment(comment,article.getId());
    }
}
