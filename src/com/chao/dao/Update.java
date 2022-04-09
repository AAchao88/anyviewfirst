package com.chao.dao;

import com.chao.po.*;
import com.chao.util.JdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update implements UpdateImp{
    /**
     * 该方法用于用户修改个人信息，通过传入int flag(1,2,3,4,5)
     * 分辨更改哪个信息，提高代码复用性
     * @param users
     * @param flag
     */
    @Override
    public void updateUsers(Users users,int flag) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = null;
            switch(flag){
                case 1:{
                    sql ="update users set username = ? where id = ?";
                    st = conn.prepareStatement(sql);
                    st.setString(1,users.getUsername()); break;
                }
                case 2:{
                    sql = "update users set password = MD5(?) where id = ?";
                    st = conn.prepareStatement(sql);
                    st.setString(1,users.getPassword()); break;
                }
                case 3:{
                    sql = "update users set sex = ? where id = ?";
                    st = conn.prepareStatement(sql);
                    st.setString(1,users.getSex()); break;
                }
                case 4:{
                    sql = "update users set telephone = ? where id = ?";
                    st = conn.prepareStatement(sql);
                    st.setString(1,users.getTelephone()); break;
                }
                case 5:{
                    sql = "update users set email = ? where id = ?";
                    st = conn.prepareStatement(sql);
                    st.setString(1,users.getEmail()); break;
                }
                default:
                }
            st.setInt(2,users.getId());
            int i = st.executeUpdate();
            if(i>0){
                System.out.println("修改成功！");
            }
        }catch (SQLException e){
            System.out.println("修改失败！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,null);
        }
    }


    /**
     * 该方法用于修改文档信息，通过传入int flag(1,2,3,4,5)
     * 分辨更改哪个信息，提高代码复用性
     *  5是修改文档的删除状态 deleteStatus，用于复原7天内删除的文档
     * @param article
     * @param flag
     */
    @Override
    public void updateArticle(Article article,int flag) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = null;
            switch(flag){
                case 1: {
                    sql ="update article set title = ? where id = ? ";
                    st = conn.prepareStatement(sql);st.setString(1,article.getTitle());
                    break;
                }
                case 2:{
                    sql = "update article set tag = ? where id = ?";st = conn.prepareStatement(sql);
                    st.setString(1,article.getTag()); break;
                }
                case 3:{
                    sql = "update article set content = ? where id = ?";st = conn.prepareStatement(sql);
                    st.setString(1,article.getContent()); break;
                }
                case 4:{

                }
                case 5:{
                    sql = "update article set delete_status = ? where id = ?";
                    st = conn.prepareStatement(sql);
                    st.setInt(1,0);
                }
                default:
            }
            st.setInt(2,article.getId());
            int i = st.executeUpdate();
            if(i>0){
                if(flag == 5){
                    System.out.println("文档复原成功！");
                }else {
                    System.out.println("修改成功！");
                }
            }
        }catch (SQLException e){
            System.out.println("操作失败！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,null);
        }
    }

    /**
     * 将作者回复的评论加入到原来的评论中
     * @param comment
     * @param id
     */
    @Override
    public void updateComment(String comment,Integer id) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = "update comment set content = ? where article_id = ?";
            st = conn.prepareStatement(sql);
            st.setString(1,comment);
            st.setInt(2,id);

            int i = st.executeUpdate();
            if(i>0){
                System.out.println("修改成功！");
            }
        }catch (SQLException e){
            System.out.println("修改失败！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,null);
        }
    }

    /**
     * 在团队中管理员修改成员权限
     * @param team
     * @param permission
     */
    @Override
    public void updatePermission(Team team, int permission) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = "update member set member_permission = ? where team_id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1,permission);
            st.setInt(2,team.getId());

            int i = st.executeUpdate();
            if(i>0){
                System.out.println("修改成功！");
            }
        }catch (SQLException e){
            System.out.println("修改失败！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,null);
        }
    }

    /**
     * 更新文档的点赞、收藏、评论数
     * @param article
     * @param flag
     */
    @Override
    public void updateInformation(Article article,int flag) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = null;
            switch (flag){
                case 1:{
                    sql =  "update article set like = ? where id = ?";
                    st = conn.prepareStatement(sql);
                    st.setInt(1,article.getLike()+1);
                    break;
                }
                case 2:{
                    sql = "update article set favorite = ? where id = ?";
                    st = conn.prepareStatement(sql);
                    st.setInt(1,article.getFavorite()+1);
                    break;
                }
                case 3:{
                    sql = "update article set comment = ? where id = ?";
                    st = conn.prepareStatement(sql);
                    st.setInt(1,article.getComment()+1);
                    break;
                }
                default:
            }
            st.setInt(2,article.getId());
            int i = st.executeUpdate();
            if(i>0){
                if(flag == 1){
                    System.out.println("点赞成功！");
                }
                if(flag == 2){
                    System.out.println("收藏成功！");
                }
            }
        }catch (SQLException e){
          //  System.out.println("修改失败！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,null);
        }
    }
}
