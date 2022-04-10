package com.chao.dao;

import com.chao.po.*;

public interface InsertImp {
    /**
     * 保存用户信息
     * @param users
     */
    void insertUsers(Users users);

    /**
     * 保存新文档信息
     */
    void insertArticle(Article article);


    /**
     * 保存知识库信息
     * @param knowledgebase
     */
    void insertKnowledgeBase(KnowledgeBase knowledgebase);

    /**
     * 保存新建团队信息
     * @param team
     */
    void insertTeam(Team team);

    /**
     * 保存 加入新团队 的信息
     * @param member
     */
    void insertJoinTeam(Member member);


    /**
     * 该方法实现了新增 点赞或收藏或评论 的功能
     * 因为三者代码类似
     * 所以通过int flag(1,2,3),分辨具体实现哪一个，
     * 集齐在一个方法
     * @param users
     * @param article
     * @param comment
     * @param flag
     */
    void insertInformation(Users users,Article article,String comment,int flag);

    void insertKnowledgebaseInTeam(KnowledgeBase knowledgeBase,Team team);


}

