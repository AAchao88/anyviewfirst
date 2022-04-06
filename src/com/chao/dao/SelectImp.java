package com.chao.dao;

import com.chao.po.*;

import java.util.LinkedList;

public interface SelectImp {
    /**
     *   查询用户
     * @param
     */
    <T> Boolean selectUsers(T input, int flag, Users users);

    /**
     *  查询文章
     * @param knowledgeBase
     */
    LinkedList<Article> selectArticle(KnowledgeBase knowledgeBase);

    LinkedList<Article> selectRecycleBin(Users users);


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

    /**
     * 查询知识库
     * 1表示通过user.id查询所有个人知识库，并获取知识库名字
     * 2表示通过知识库名字获取知识库id
     * @return
     */
    LinkedList<String > selectKnowledgeBase(Users users,int item);

    Integer selectIdByName(String name);

    LinkedList<Team> selectManageTeam(Users users);

    LinkedList<Team> selectJoinTeam(Users users);



}
