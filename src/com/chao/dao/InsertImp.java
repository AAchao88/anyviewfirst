package com.chao.dao;

import com.chao.po.*;

public interface InsertImp {
    /**
     * 保存用户信息
     * @param users
     */
    void insertUsers(Users users);

    /**
     * 保存文章信息
     */
    void insertArticle(Article article);

    /**
     * 保存评论信息
     * @param comment
     */
    void insertComment(Comment comment);

    /**
     * 保存收藏信息
     * @param favorite
     */
    void insertFavorite(Favorite favorite);


    /**
     * 保存知识库信息
     * @param knowledgebase
     */
    void insertKnowledge(Knowledgebase knowledgebase);
}