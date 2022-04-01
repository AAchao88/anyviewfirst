package com.chao.dao;

import com.chao.po.Article;
import com.chao.po.Comment;
import com.chao.po.Favorite;
import com.chao.po.Users;

public interface UpdateImp {
    /**
     *
     * @param users
     */
    void updateUsers(Users users);

    /**
     *
     * @param article
     */
    void updateArticle(Article article);

    /**
     *
     * @param comment
     */
    void updateComment(Comment comment);

    /**
     *
     * @param favorite
     */
    void updateFavorite(Favorite favorite);
}
