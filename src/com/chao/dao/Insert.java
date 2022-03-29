package com.chao.dao;

import com.chao.util.JdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


//将数据保存到数据库

public class Insert<T> {
    public <T> void insert(){
        Connection conn = null;
        PreparedStatement st = null;

        try{
            conn = JdbcUtils_DBCP.getConnection();
            //区别    //使用？ 占位符代替参数
            String sql = "insert into users(id,`username`,`password`,`sex`,`telephone`,`email`)values(?,?,?,?,?,?)";
            st = conn.prepareStatement(sql);
            //预编译SQL，先写sql,然后不执行

            //手动给参数赋值
            st.setInt(1,6);
            st.setString(2,"chao");
            st.setString(3,"112345");
            st.setString(4,"234@23.com");
            st.setString(5,"1980-12-30");
            //注意点：sql/date   数据库
            //          utils.Date  java    new Date().getTime() 获得时间戳
            int i = st.executeUpdate();
            if(i>0){
                System.out.println("插入成功！");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,null);
        }
    }

}
