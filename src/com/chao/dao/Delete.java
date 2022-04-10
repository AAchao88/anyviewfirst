package com.chao.dao;

import com.chao.controler.verify.Verify;
import com.chao.po.Article;
import com.chao.po.Member;
import com.chao.util.JdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete implements DeleteImp{

    /**
     * 假性删除文档，
     * 即7天内可在回收站复原
     */
    @Override
    public void deleteArticleFake(Article article) {
        Verify verify = new Verify();
        System.out.println("1.确定删除文档      2.返回     ");
        int flag = verify.menuItemVerify(1,2);
        if(flag == 2){
            return;
        }
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = "update article set delete_status = ?,delete_time = ? where id = ?";
            st = conn.prepareStatement(sql);

            st.setInt(1,1);
            st.setDate(2,new java.sql.Date(System.currentTimeMillis()));
            st.setInt(3,article.getId());

            int i = st.executeUpdate();
            if(i>0){

                System.out.println("删除成功！");
            }
        }catch (SQLException e){
            System.out.println("删除失败！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,null);
        }
    }

    /**
     * 真正删除文档，不可复原
     * 该方法在回收站中被调用
     */
    @Override
    public void deleteArticleTrue(Article article) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = "delete from article where id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1,article.getId());

            int i = st.executeUpdate();
            if(i>0){
                System.out.println("删除成功！");
            }
        }catch (SQLException e){
            System.out.println("删除失败！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,null);
        }
    }

    /**
     * 删除收藏的文档
     */
    @Override
    public void deleteFavorite(Article article) {
        Verify verify = new Verify();
        System.out.println("1.确定删除文档      2.返回     ");
        int flag = verify.menuItemVerify(1,2);
        if(flag == 2){
            return;
        }
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = "delete from favorite where article_id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1,article.getId());

            int i = st.executeUpdate();
            if(i>0){
                System.out.println("删除成功！");
            }
        }catch (SQLException e){
            System.out.println("删除失败！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,null);
        }
    }

    @Override
    public void deleteMember(Member member) {
        Verify verify = new Verify();
        System.out.println("1.确定删除该成员      2.返回     ");
        int flag = verify.menuItemVerify(1,2);
        if(flag == 2){
            return;
        }
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = "delete from member where member_id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1,member.getMember_id());

            int i = st.executeUpdate();
            if(i>0){
                System.out.println("删除成功！");
            }
        }catch (SQLException e){
            System.out.println("删除失败！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,null);
        }
    }
}
