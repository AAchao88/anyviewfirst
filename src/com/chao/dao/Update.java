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
            //区别    //使用？ 占位符代替参数
           // String sql = "update users set ";
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
            //预编译SQL，先写sql,然后不执行

            //手动给参数赋值
//            st.setInt(1,users.getId());
//            st.setString(2,users.getUsername());
//            st.setString(3,users.getPassword());
//            st.setString(4,users.getSex());
//            st.setInt(5,users.getTelephone());
//            st.setString(6,users.getEmail());


            //注意点：sql/date   数据库
            //          utils.Date  java    new Date().getTime() 获得时间戳
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
