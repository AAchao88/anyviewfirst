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
    Boolean selectUsers(Users users,int flag);

    /**
     *  查询文章
     * @param article
     */
    Boolean selectArticle(Article article);

    /**
     *  查询评论
     * @param comment
     */
    Boolean selectComment(Comment comment);

    /**
     *     查询收藏
     * @param favorite
     */
    Boolean selectFavorite(Favorite favorite);

   // Boolean selectSex(Users users);
}
