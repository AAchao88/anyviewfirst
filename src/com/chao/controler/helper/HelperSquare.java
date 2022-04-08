package com.chao.controler.helper;

import com.chao.controler.verify.Verify;
import com.chao.dao.Select;
import com.chao.po.Article;

import java.util.LinkedList;

public class HelperSquare {

    public LinkedList<Article> showShared(){
        Select select = new Select();
        Verify verify = new Verify();

        LinkedList<Article> listShared = select.selectSharedArticle();
        int i = 0;
        for(i = 0;!listShared.isEmpty();i++){
            System.out.println((i+1)+"."+listShared.get(i).getTitle());
            System.out.println("\t\t标签-->"+listShared.get(i).getTag());
            i++;
        }
        System.out.println("请输入序号选择要查看的文档：");
        int serialNum = verify.menuItemVerify(1,i);
        System.out.println("\t\t"+listShared.get(serialNum-1).getTitle());
        System.out.println(listShared.get(serialNum-1));

        return listShared;
    }


}
