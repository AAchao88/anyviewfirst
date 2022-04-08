package com.chao.dao;

import com.chao.po.Article;
import com.chao.po.Comment;
import com.chao.po.Users;

public interface DeleteImp {
    /**
     *
     * @param users
     */
    void deleteUsers(Users users);

    /**
     *
     * @param article
     */
    void deleteArticleFake(Article article);

    void deleteArticleTrue(Article article);

    /**
     *
     * @param comment
     */
    void deleteComment(Comment comment);

    /**
     *
     * @param favorite
     */
    void deleteFavorite(Article article);
}
