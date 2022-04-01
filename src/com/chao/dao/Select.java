package com.chao.dao;

import com.chao.po.Article;
import com.chao.po.Comment;
import com.chao.po.Favorite;
import com.chao.po.Users;
import com.chao.util.JdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Select implements SelectImp{
    @Override
    public void selectUsers(Users users) {
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();
            //区别    //使用？ 占位符代替参数
            String sql =
            st = conn.prepareStatement(sql);
            //预编译SQL，先写sql,然后不执行

            //手动给参数赋值

            //注意点：sql/date   数据库
            //          utils.Date  java    new Date().getTime() 获得时间戳
            int i = st.executeUpdate();
            if(i>0){
                System.out.println("保存成功！");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,null);
        }
    }

    @Override
    public void selectArticle(Article article) {

    }

    @Override
    public void selectComment(Comment comment) {

    }

    @Override
    public void selectFavorite(Favorite favorite) {

    }
}
