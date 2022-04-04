package com.chao.dao;

import com.chao.po.Article;
import com.chao.po.Comment;
import com.chao.po.Favorite;
import com.chao.po.Users;
import com.chao.service.modify.ModifyMine;
import com.chao.util.JdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update implements UpdateImp{


    @Override
    public void updateUsers(Users users) {
        ModifyMine modifyMine = new ModifyMine();
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = null;
            switch(modifyMine.getFlag()){
                case 1: sql ="";st.setString(1,users.getUsername()); break;
                case 2:sql = "";st.setString(1,users.getPassword()); break;
                case 3:sql = "";st.setString(1,users.getSex()); break;
                case 4:sql = "";st.setString(1,users.getTelephone()); break;
                case 5:sql = "";st.setString(1,users.getEmail()); break;
                default:
            }
            st = conn.prepareStatement(sql);
            int i = st.executeUpdate();
            if(i>0){
                //System.out.println("保存成功！");
                return ;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,null);
        }
    }

    @Override
    public void updateArticle(Article article) {

    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public void updateFavorite(Favorite favorite) {

    }
}
