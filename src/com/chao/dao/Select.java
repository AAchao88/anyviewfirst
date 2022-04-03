package com.chao.dao;

import com.chao.po.*;
import com.chao.util.JdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select implements SelectImp{
    /**
     * flag变量用来判断查询的内容，实现一个方法完成多个功能，
     *      1代表通过用户id查询user表的一整行数据，即一个用户的全部信息，用于查看个人信息
     *      2代表通过用户名查询并返回用户id，用于登陆时获取users.userId,
     *      3传入用户的输入查询用户名是否已经存在
     *      4输入可能的密码查询密码是否正确
     * @param users
     * @param flag
     * @return
     */
    private Boolean returnValue;
    @Override
    public <T>Boolean selectUsers(T input,int flag,Users users) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            conn = JdbcUtils_DBCP.getConnection();
            //区别    //使用？ 占位符代替参数
            //String sql = "select * from users where id = ? ";
            String sql = null;
            switch(flag){
                case 1:sql = "select * from users where id = ?";
                        st = conn.prepareStatement(sql);
                        st.setObject(1, input);
                        break;
                case 2:sql = "select `id` from users where username = ?";
                        st = conn.prepareStatement(sql);
                        st.setObject(1,input);
                        break;
                case 3:sql = "select * from users where username  = ? ";st = conn.prepareStatement(sql);
                    st.setObject(1,input);break;
                case 4:sql = "select `password` from users where username = ?";
                                st = conn.prepareStatement(sql);
                                st.setObject(1,users.getUsername());
                                break;
                default:
            }
            //st = conn.prepareStatement(sql);
            //预编译SQL，先写sql,然后不执行

            //st.setInt(1,);

            //手动给参数赋值

            //注意点：sql/date   数据库
            //          utils.Date  java    new Date().getTime() 获得时间戳
           rs = st.executeQuery();
           if(rs.next()){
               //System.out.println(rs.getString("name"));
               switch(flag){
                   case 1:
                       System.out.println("您的用户id是："+rs.getInt("id"));
                       System.out.println("您的用户名是："+rs.getString("username"));
                       System.out.println("您的性别是："+rs.getString("sex"));
                       System.out.println("您的联系电话是："+rs.getString("telephone"));
                       System.out.println("您的电子邮箱是："+rs.getString("email"));
                       returnValue = true;break;
                   case 2:users.setId(rs.getInt("id"));
                       returnValue = true; break;
                   case 3:returnValue = true;break;
                   case 4:if(input.equals(rs.getString("passoword"))){
                       returnValue = true;
                       break;
                   }else{
                       returnValue = false;
                       break;
                   }
                   default:
               }

           }else{
               //System.out.println("查无！");
               returnValue = false;
           }


        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,rs);
            return returnValue;
        }
    }

    @Override
    public Boolean selectArticle(Article article) {
        return true;
    }

    @Override
    public Boolean selectComment(Comment comment) {
        return true;
    }

    @Override
    public Boolean selectFavorite(Favorite favorite) {
        return true;
    }

    @Override
    public String[] selectPersonalKnowledgeBase(Users users, int flag,String[] storeKnowledgeName) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            conn = JdbcUtils_DBCP.getConnection();
            //区别    //使用？ 占位符代替参数
            //String sql = "select * from users where id = ? ";
            String sql = null;
            switch (flag){
                case 1:sql = "select * from knowledgebase where `create_user_id` = ? and `category` =  ?";
                    st = conn.prepareStatement(sql);
                    st.setInt(1,users.getId());
                    st.setString(2,"个人知识库");
                    rs = st.executeQuery();
                    for(int i=0;rs.next();i++){
                        storeKnowledgeName[i] = rs.getString("knowledgebase_name");
                    }
                    break;
                case 2:sql = "select `id` from knowledgebase where `knowledge_name` = ?";
                    st = conn.prepareStatement(sql);
                    st.setString(1,knowledgeBase.getKnowledgebase_name());
            }
            //st = conn.prepareStatement(sql);
            //预编译SQL，先写sql,然后不执行

            //st.setInt(1,);

            //手动给参数赋值

            //注意点：sql/date   数据库
            //          utils.Date  java    new Date().getTime() 获得时间戳
            rs = st.executeQuery();

            if(rs.next()){

            }else{

               // returnValue = false;
            }


        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,rs);
            if(flag == 1){
                return storeKnowledgeName;
            }else {
                return null;
            }
        }

    }
}
