package com.chao.service.OperateImp;

import com.chao.po.KnowledgeBase;
import com.chao.po.Users;


/**
 * Home类最主要的功能实现类
 */
public interface HomeImp {
    /**
     *        我的
     *先显示所有用户信息和修改界面
     */
    void mine(Users users);

    /**
     * 广场的实现方法
     * @param users
     */
     void square(Users users);


    /**
     * 团队
     * 1、作为管理员可以  获取邀请码让其他用户加入、踢出成员、设置成员的知识库的权限（比如限制文章的读、修改、评论）
     *                   输出所有、编辑、新建、（投稿）、删除文章
     * 2、输出所有、编辑、新建、（共享）文章，输出权限提示
     */
      void team(Users users);


    /**
     * 收藏
     *
     * 通过userid查询收藏表，再查看删除时间是否为空
     *      如果不为空且距今超过7天则删除表中的该数据
     *      否则输出
     * 输出当前收藏数,getFavoriteNum()
     * 输出  1、查看收藏   2、删除收藏的文章  3、返回
     *      依据文章id查看或删除
     *      实际上并没有删除文章，
     * 打印收藏文章的标题和编号id,getArticleTitle()
     *
     */
     void favorite(Users users);


    /**
     *   新建知识库
     *   获取知识库id，将其赋到文章信息
     *   要求输入知识库的信息（分类为个人还是协作，name,tag,）
     *   联系数据库
     */
     KnowledgeBase create_knowledge_base(Users users,int flag);


    /**
     *   回收站
     *   通过userid查询收藏表，再查看删除时间是否为空
     *   如果不为空，则判断是否超过7天
     *   是则  删除表中该数据
     *   否则  打印文章的title，询问是否复原
     */
     void recycleBin(Users users);

    /**
     * 新建文档的实现方法
     * @param users
     * @param kb_id
     */
     void newArticle(Users users, Integer kb_id);


    /**
     *
     * 通过user.id查询所有知识库,分为个人知识库和协作知识库
     */
    void Knowledge_base(Users users, int item);


    /**
     * 编辑已有文档的实现方法
     * @param users
     * @param kb_id
     */
    void editArticle(Users users, Integer kb_id);

}
