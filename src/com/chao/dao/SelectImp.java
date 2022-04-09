package com.chao.dao;

import com.chao.po.*;

import java.util.LinkedList;

public interface SelectImp {

    /**
     * flag变量用来判断查询的内容，实现一个方法完成多个功能，
     *      1代表通过用户id查询user表的一整行数据，即一个用户的全部信息，用于查看个人信息
     *      2代表通过用户名查询并返回用户id，用于登陆时获取users.userId,
     *      3传入用户的输入查询用户名是否已经存在
     *      4输入可能的密码查询密码是否正确
     * @param users
     * @param flag
     * @return
     */
    <T> Boolean selectUsers(T input, int flag, Users users);

    /**
     * 查询文档信息
     * @param id
     * @return
     */
    LinkedList<Article> selectArticle(Integer id);

    /**
     * 查询所有假性删除的文档，
     * 返回给回收站，回收站将删除时间判断是否超过7天
     * @param users
     * @return
     */
    LinkedList<Article> selectRecycleBin(Users users);


    /**
     * 查询文档的所有评论
     * @param article
     * @return
     */
    LinkedList<String> selectComment(Article article);

    /**
     *  查询收藏的文档
     * @param users
     */
    LinkedList<Article> selectFavorite(Users users);


    /**
     * 查询知识库，这里的item与home首页方法中的item一致
     * 用于判断查询个人知识库还是协作知识库
     * @param id
     * @param item
     * @return
     */
    LinkedList<String > selectKnowledgeBase(int id,int item);

    /**
     *通过id查询name
     * @param name
     * @return
     */
    Integer selectIdByName(String name);

    /**
     * 查询用户所有创建的团队（即管理的团队）
     * @param users
     * @return
     */
    LinkedList<Team> selectManageTeam(Users users);


    /**
     * 查询用户加入的所有团队
     * @param users
     * @return
     */
    LinkedList<Team> selectJoinTeam(Users users);


    /**
     * 在团队中查询所有的成员（不包括管理员）
     * @param team
     * @return
     */
    LinkedList<Member> selectMember(Team team);

    /**
     * 查询用户在团队中的权限
     * @param team
     * @param users
     * @return
     */
    int selectPermission(Team team,Users users);


    /**
     * 查询文档的标题和内容，用于广场
     * @param article
     * @return
     */
    Article selectArticleContent(Article article);


    /**
     * 新建团队时生成邀请码
     * @param input
     * @param users
     * @return
     */
    Member selectIvCode(String input,Users users);


    /**
     * 管理员获取相应邀请码
     * @param team
     * @param permission
     * @return
     */
    String selectCode(Team team,int permission);


    /**
     * 查询共享文档，并按点赞数降序输出
     * @return
     */
    LinkedList<Article> selectSharedArticle();


    /**
     * 用于判断用户对某文档已经点赞或收藏过
     * 避免重复点赞
     * @param users
     * @param article
     * @param flag
     * @return
     */
    Boolean selectRepeat(Users users,Article article,int flag);


}
