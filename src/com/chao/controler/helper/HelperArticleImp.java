package com.chao.controler.helper;

import com.chao.po.Article;

import java.util.Date;

public interface HelperArticleImp {

    String helperWrite();
    String helperEdit(String original,int flag);
    void printInformation(Article article);
    void exportLocal(Article article);
    Long computationDayTime(Date startTime, Date endTime);
}
