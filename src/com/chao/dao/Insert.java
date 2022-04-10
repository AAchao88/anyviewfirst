package com.chao.dao;

import com.chao.po.*;
import com.chao.util.JdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 插入新数据到数据库
 */

public class Insert implements InsertImp {

    /**
     * 插入新用户信息
     * @param users
     */
    @Override
    public void insertUsers(Users users) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = JdbcUtils_DBCP.getConnection();

            String sql = "insert into users(`username`,`password`,`sex`,`telephone`,`email`)values(?,MD5(?),?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1, users.getUsername());
            st.setString(2, users.getPassword());
            st.setString(3, users.getSex());
            st.setString(4, users.getTelephone());
            st.setString(5, users.getEmail());
            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("保存成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils_DBCP.release(conn, st, null);
        }
    }

    /**
     * 保存新文档信息
     */
    @Override
    public void insertArticle(Article article) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = JdbcUtils_DBCP.getConnection();

            String sql = "insert into article(`author_id`,`knowbase_id`,`title`,`tag`,`content`,`shared`,`create_time`)values (?,?,?,?,?,?,?) ";
            st = conn.prepareStatement(sql);
            st.setInt(1,article.getAuthor_id());
            st.setInt(2,article.getKnowledgebase_id());
            st.setString(3,article.getTitle());
            st.setString(4,article.getTag());
            st.setString(5,article.getContent());
            st.setInt(6,article.getShared());
            st.setDate(7,new java.sql.Date(article.getCreate_time().getTime()));
            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("保存成功！");
            }
        } catch (SQLException e) {
            System.out.println("新建失败！请重试。");
            //e.printStackTrace();
        } finally {
            JdbcUtils_DBCP.release(conn, st, null);
        }
    }


    /**
     * 保存知识库信息
     *
     * @param knowledgebase
     */
    @Override
    public void insertKnowledgeBase(KnowledgeBase knowledgebase) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = JdbcUtils_DBCP.getConnection();
            String sql = "insert into knowledgebase(`knowledgebase_name`,`create_user_id`,`create_time`,`tag`,`category`)values(?,?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1,knowledgebase.getKnowledgebase_name());
            st.setInt(2,knowledgebase.getCreate_user_id());
            st.setDate(3, new java.sql.Date(knowledgebase.getCreate_time().getTime()));
            st.setString(4,knowledgebase.getTag());
            st.setString(5,knowledgebase.getCategory());

            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("新建知识库成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils_DBCP.release(conn, st, null);
        }
    }

    /**
     * 保存新建团队信息
     * @param team
     */
    @Override
    public void insertTeam(Team team) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = JdbcUtils_DBCP.getConnection();

            String sql = "insert into team(`create_user_id`,`team_name`,`invitationCode1`,`invitationCode2`,`invitationCode3`)values(?,?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setInt(1,team.getCreate_user_id());
            st.setString(2,team.getTeam_name());
            st.setString(3,team.getInvitationCode1());
            st.setString(4,team.getInvitationCode2());
            st.setString(5,team.getInvitationCode3());

            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("新建团队成功！");
            }
        } catch (SQLException e) {
            System.out.println("新建团队失败！");
            e.printStackTrace();
        } finally {
            JdbcUtils_DBCP.release(conn, st, null);
        }
    }

    /**
     * 保存 加入新团队 的信息
     * @param member
     */
    @Override
    public void insertJoinTeam(Member member) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = JdbcUtils_DBCP.getConnection();

            String sql = "insert into member (team_id,member_id,member_permission,member_name,team_name)values(?,?,?,?,?) ";
            st = conn.prepareStatement(sql);
            st.setInt(1,member.getTeam_id());
            st.setInt(2,member.getMember_id());
            st.setInt(3,member.getMember_permission());
            st.setString(4,member.getMember_name());
            st.setString(5,member.getTeam_name());

            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("加入团队成功！");
            }
        } catch (SQLException e) {
            System.out.println("加入团队失败！");
            e.printStackTrace();
        } finally {
            JdbcUtils_DBCP.release(conn, st, null);
        }
    }

    /**
     * 该方法实现了新增 点赞或收藏或评论 的功能
     * 因为三者代码类似
     * 所以通过int flag(1,2,3),分辨具体实现哪一个，
     * 集齐在一个方法
     * @param users
     * @param article
     * @param comment
     * @param flag
     */
    @Override
    public void insertInformation(Users users, Article article,String comment, int flag) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = JdbcUtils_DBCP.getConnection();
            String sql = null;
            switch (flag){
                case 1:{
                    sql =  "insert into `like` (create_user_id,article_id)values(?,?) ";
                    st = conn.prepareStatement(sql);
                    st.setInt(1,users.getId());
                    st.setInt(2,article.getId());
                    break;
                }
                case 2:{
                    sql =  "insert into favorite (user_id,article_id)values(?,?) ";
                    st = conn.prepareStatement(sql);
                    st.setInt(1,users.getId());
                    st.setInt(2,article.getId());
                    break;
                }
                case 3:{
                    sql =  "insert into comment (create_user_id,article_id,content)values(?,?,?) ";
                    st = conn.prepareStatement(sql);
                    st.setInt(1,users.getId());
                    st.setInt(2,article.getId());
                    st.setString(3,comment);
                    break;
                }
                default:
            }

            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("成功！");
            }
        } catch (SQLException e) {
            System.out.println("失败！");
            e.printStackTrace();
        } finally {
            JdbcUtils_DBCP.release(conn, st, null);
        }
    }

    /**
     * 在团队中加入协作知识库
     */
    @Override
    public void insertKnowledgebaseInTeam(KnowledgeBase knowledgeBase,Team team) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = JdbcUtils_DBCP.getConnection();

            String sql = "insert into member (team_id,team_name,knowledgebase_id,knowledgebase_name)values(?,?,?,?) ";
            st = conn.prepareStatement(sql);
            st.setInt(1,team.getId());
            st.setString(2,team.getTeam_name());
            st.setInt(3,knowledgeBase.getId());
            st.setString(4,knowledgeBase.getKnowledgebase_name());

            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("新建协作知识库成功！");
            }
        } catch (SQLException e) {
            System.out.println("失败！");
            e.printStackTrace();
        } finally {
            JdbcUtils_DBCP.release(conn, st, null);
        }
    }

}
