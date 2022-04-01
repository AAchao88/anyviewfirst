package com.chao.dao;

import com.chao.po.Article;
import com.chao.po.Comment;
import com.chao.po.Favorite;
import com.chao.po.Users;

public interface SelectImp {
    /**
     *   查询用户
     * @param users
     */
    void selectUsers(Users users);

    /**
     *  查询文章
     * @param article
     */
    void selectArticle(Article article);

    /**
     *  查询评论
     * @param comment
     */
    void selectComment(Comment comment);

    /**
     *     查询收藏
     * @param favorite
     */
    void selectFavorite(Favorite favorite);
}
