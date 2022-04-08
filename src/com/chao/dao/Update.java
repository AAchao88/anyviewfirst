package com.chao.dao;

import com.chao.po.*;
import com.chao.util.JdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update implements UpdateImp{


    @Override
    public void updateUsers(Users users,int flag) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = null;
            switch(flag){
                case 1: sql ="";st = conn.prepareStatement(sql);st.setString(1,users.getUsername()); break;
                case 2:sql = "";st = conn.prepareStatement(sql);st.setString(1,users.getPassword()); break;
                case 3:sql = "";st = conn.prepareStatement(sql);st.setString(1,users.getSex()); break;
                case 4:sql = "";st = conn.prepareStatement(sql);st.setString(1,users.getTelephone()); break;
                case 5:sql = "";st = conn.prepareStatement(sql);st.setString(1,users.getEmail()); break;
                default:
            }

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
     *  5是修改文档的删除状态 deleteStatus
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
            return;
        }
    }

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

    @Override
    public void updateFavorite(Favorite favorite) {

    }

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

    @Override
    public void updateInformation(Article article,int flag) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = null;
            switch (flag){
                case 1:{
                    sql =  "update article set like = ? where article_id = ?";
                    st = conn.prepareStatement(sql);
                    st.setInt(1,article.getLike()+1);
                    break;
                }
                case 2:{
                    sql = "update article set favorite = ? where article_id = ?";
                    st = conn.prepareStatement(sql);
                    st.setInt(1,article.getFavorite()+1);
                    break;
                }
                case 3:{
                    sql = "update article set comment = ? where article_id = ?";
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
