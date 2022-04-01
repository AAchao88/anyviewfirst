package com.chao.dao;

import com.chao.po.*;
import com.chao.util.JdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


//将数据保存到数据库

public class Insert implements InsertImp {
    @Override
    public void insertUsers(Users users){
        Connection conn = null;
        PreparedStatement st = null;

        try{
            conn = JdbcUtils_DBCP.getConnection();
            //区别    //使用？ 占位符代替参数
            String sql = "insert into users(`id`,`username`,`password`,`sex`,`telephone`,`email`)values(?,?,?,?,?,?)";
            st = conn.prepareStatement(sql);
            //预编译SQL，先写sql,然后不执行

            //手动给参数赋值
            st.setInt(1,users.getId());
            st.setString(2,users.getUsername());
            st.setString(3,users.getPassword());
            st.setString(4,users.getSex());
            st.setInt(5,users.getTelephone());
            st.setString(6,users.getEmail());


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

    /**
     * 保存文章信息
     */
    @Override
    public void insertArticle(Article article){

    }

    /**
     * 保存评论信息
     * @param comment
     */
    @Override
    public void insertComment(Comment comment){

    }

    /**
     * 保存收藏信息
     * @param favorite
     */
    @Override
    public void insertFavorite(Favorite favorite){

    }

    /**
     * 保存知识库信息
     * @param knowledgebase
     */
    @Override
    public void insertKnowledge(Knowledgebase knowledgebase){

    }

}
