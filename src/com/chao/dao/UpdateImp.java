package com.chao.dao;

import com.chao.po.*;

public interface UpdateImp {
    /**
     *
     * @param users
     */
    void updateUsers(Users users,int flag);

    /**
     *
     * @param article
     */
    void updateArticle(Article article,int flag);

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

    void updatePermission(Team team, int permission);


}
