package com.chao.controler.helper;

import com.chao.controler.verify.Verify;
import com.chao.dao.Select;
import com.chao.po.Article;

import java.util.LinkedList;

public class HelperSquare {

    /**
     * 在广场中查询共享文档，让用户选择文档，并输出文档标题和内容
     * 返回选中的文档
     * @return
     */
    public Article showShared(){
        Select select = new Select();
        Verify verify = new Verify();

        LinkedList<Article> listShared = select.selectSharedArticle();
        if(listShared.isEmpty()){
            System.out.println("暂无共享文档！");
            return null;
        }
        int i = 0;
        for(i = 0;listShared.size()>i;i++){
            System.out.println((i+1)+"."+listShared.get(i).getTitle());
            System.out.println("\t\t标签-->"+listShared.get(i).getTag());
            i++;
        }
        System.out.println("请输入序号选择要查看的文档：");
        int serialNum = verify.menuItemVerify(1,i);
        System.out.println("\t\t"+listShared.get(serialNum-1).getTitle());
        System.out.println(listShared.get(serialNum-1).getContent());

        return listShared.get(serialNum-1);
    }

    /**
     * 传入一个文档article，输出它的相关信息
     */
    public void showInformation(Article article){
        System.out.println("\n该文档的点赞数为："+article.getLike());
        System.out.println("该文档的收藏数为："+article.getFavorite());
        System.out.println("该文档的评论数为："+article.getComment());
        System.out.println("该文档的创建时间是："+article.getCreate_time());
        System.out.println("该文档的最新更改时间是："+article.getUpdate_time());

    }


}
