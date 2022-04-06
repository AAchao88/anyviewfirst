package com.chao.dao;

import com.chao.po.*;
import com.chao.util.JdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


//将数据保存到数据库

public class Insert implements InsertImp {
    @Override
    public void insertUsers(Users users) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = JdbcUtils_DBCP.getConnection();

            String sql = "insert into users(`username`,`password`,`sex`,`telephone`,`email`)values(?,?,?,?,?)";
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
     * 保存文章信息
     */
    @Override
    public void insertArticle(Article article) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = JdbcUtils_DBCP.getConnection();

            String sql = "insert into article(`author_id`,`knowbase_id`,`title`,`tag`,`content`,`shared`,`create_time`)values (?,?,?,?,?,?,?) ";
            st = conn.prepareStatement(sql); //预编译SQL，先写sql,然后不执行
            st.setInt(1,article.getAuthor_id());
            st.setInt(2,article.getKnowledgebase_id());
            st.setString(3,article.getTitle());
            st.setString(4,article.getTag());
            st.setString(5,article.getContent());
            st.setInt(6,article.getShared());
            st.setDate(7,article.getCreate_time());
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
     * 保存评论信息
     *
     * @param comment
     */
    @Override
    public void insertComment(Comment comment) {

    }

    /**
     * 保存收藏信息
     *
     * @param favorite
     */
    @Override
    public void insertFavorite(Favorite favorite) {

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
            //区别    //使用？ 占位符代替参数
            String sql = "insert into knowledgebase(`knowledgebase_name`,`create_user_id`,`create_time`,`tag`,`category`)values(?,?,?,?,?)";
            st = conn.prepareStatement(sql);
            //预编译SQL，先写sql,然后不执行

            //手动给参数赋值
            // st.setInt(1,users.getId());
            st.setString(1,knowledgebase.getKnowledgebase_name());
            st.setInt(2,knowledgebase.getCreate_user_id());
            st.setDate(3,knowledgebase.getCreate_time());
            st.setString(4,knowledgebase.getTag());
            st.setString(5,knowledgebase.getCategory());
            //注意点：sql/date   数据库
            //          utils.Date  java    new Date().getTime() 获得时间戳
            int i = st.executeUpdate();
            if (i > 0) {
                System.out.println("新建知识库成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils_DBCP.release(conn, st, null);
            return;
        }
    }

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
            return;
        }
    }

}
