package com.chao.service.OperateImp;

import com.chao.po.KnowledgeBase;
import com.chao.po.Users;

public interface HomeImp {
    /**
     *        我的
     *先显示所有用户信息和修改界面
     */
    void mine(Users users);


    /**
     * 广场
     * 1.依据文章的点赞数排序，显示？篇文章，分页功能
     *    要跳出搜索框，用户可以查找（根据关键字或文章标签即分类）
     * 2.调用数据库文章表，输出文章的内容、点赞数、收藏数、作者、写作时间、修改时间，可以评论
     * 3.用户可以点赞、收藏、评论文章，此时变量articleId应该被赋值，通过这个对文章进行操作
     */
     void square(Users users);


    /**
     * 团队
     * 分为1、你创建的协作知识库和2、你加入的协作知识库
     * 1、作为管理员可以  获取邀请码让其他用户加入、踢出成员、设置成员的知识库的权限（比如限制文章的读、修改、评论）
     *                   输出所有、编辑、新建、（投稿）、删除文章
     * 2、输出所有、编辑、新建、（投稿）文章，输出权限提示
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
     *   个人知识库
     *   获取知识库id，将其赋到文章信息
     *   可以输出、新建、编辑、tag标签、删除、（投稿）文章
     */
     void personal_Knowledge_base(Users users);

    /**
     *   新建知识库
     *   获取知识库id，将其赋到文章信息
     *   要求输入知识库的信息（分类为个人还是协作，name,tag,）
     *   联系数据库
     */
     void create_knowledge_base(Users users);

    /**
     *   协作知识库
     *   获取知识库id，将其赋到文章信息
     *   显示知识库信息，管理员、文章、自己的权限、tag
     *   可以根据权限   输出、新建、编辑、tag标签、删除、（投稿）文章
     */
    void cooperate_knowledge_base(Users users);

    /**
     *   回收站
     *   通过userid查询收藏表，再查看删除时间是否为空
     *   如果不为空，则判断是否超过7天
     *   是则  删除表中该数据
     *   否则  打印文章的title，询问是否复原
     */
     void recycleBin(Users users);

     void newArticle(Users users, KnowledgeBase knowledgeBase);

}
