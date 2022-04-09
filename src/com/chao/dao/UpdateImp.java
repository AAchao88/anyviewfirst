package com.chao.dao;

import com.chao.po.*;

public interface UpdateImp {
    /**
     * 该方法用于用户修改个人信息，通过传入int flag(1,2,3,4,5)
     * 分辨更改哪个信息，提高代码复用性
     * @param users
     * @param flag
     */
    void updateUsers(Users users,int flag);

    /**
     * 该方法用于修改文档信息，通过传入int flag(1,2,3,4,5)
     * 分辨更改哪个信息，提高代码复用性
     *  5是修改文档的删除状态 deleteStatus，用于复原7天内删除的文档
     * @param article
     * @param flag
     */
    void updateArticle(Article article,int flag);

    /**
     * 将作者回复的评论加入到原来的评论中
     * @param comment
     * @param id
     */
    void updateComment(String comment,Integer id);

    /**
     * 在团队中管理员修改成员权限
     * @param team
     * @param permission
     */
    void updatePermission(Team team, int permission);


    /**
     * 更新文档的点赞、收藏、评论数
     * @param article
     */
    void updateInformation(Article article,int flag);


}
