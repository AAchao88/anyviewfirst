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
    void updateComment(String comment,Integer id);

    /**
     *
     * @param favorite
     */
    void updateFavorite(Favorite favorite);

    void updatePermission(Team team, int permission);


    /**
     * 更新文档的点赞、收藏、评论数
     * @param article
     */
    void updateInformation(Article article,int flag);


}
