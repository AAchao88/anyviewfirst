package com.chao.dao;

import com.chao.po.*;
import com.chao.util.JdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

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
    private Boolean returnValue1;
    private Integer returnValue2;
    @Override
    public <T>Boolean selectUsers(T input,int flag,Users users) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            conn = JdbcUtils_DBCP.getConnection();
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
                       returnValue1 = true;break;
                   case 2:users.setId(rs.getInt("id"));
                       returnValue1 = true; break;
                   case 3:returnValue1 = true;break;
                   case 4:if(input.equals(rs.getString("passoword"))){
                       returnValue1 = true;
                       break;
                   }else{
                       returnValue1 = false;
                       break;
                   }
                   default:
               }
           }else{
               //System.out.println("查无！");
               returnValue1 = false;
           }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,rs);
            return returnValue1;
        }
    }

    @Override
    public LinkedList<Article> selectArticle(KnowledgeBase knowledgeBase) {
        LinkedList<Article> listArticle = new LinkedList<>();
      Connection conn = null;
      PreparedStatement st = null;
      ResultSet rs = null;
      try{
          conn = JdbcUtils_DBCP.getConnection();
          String sql = null;
          sql = "select * from article where knowbase_id = ? and delete_status = 0";
          st = conn.prepareStatement(sql);
          st.setInt(1,knowledgeBase.getId());
          rs = st.executeQuery();
          int i =0 ;
          while (rs.next()){
                listArticle.get(i).setId(rs.getInt("id"));
                listArticle.get(i).setTitle(rs.getString("title"));
              listArticle.get(i).setContent(rs.getString("content"));
              listArticle.get(i).setId(rs.getInt("author_id"));
              listArticle.get(i).setCreate_time(rs.getDate("create_time"));
              listArticle.get(i).setUpdate_time(rs.getDate("update_time"));
              listArticle.get(i).setLike(rs.getInt("like"));
              listArticle.get(i).setFavorite(rs.getInt("favorite"));
              listArticle.get(i).setComment(rs.getString("comment"));
              listArticle.get(i).setTag(rs.getString("tag"));
              listArticle.get(i).setKnowledgebase_id(rs.getInt("knowledge_id"));
              listArticle.get(i).setShared(rs.getInt("shared"));
              i++;
          }
      }catch (SQLException e){
          System.out.println("查询失败！");
          e.printStackTrace();
      }finally{
          JdbcUtils_DBCP.release(conn,st,rs);
          return listArticle;
      }


    }

    @Override
    public LinkedList<Article> selectRecycleBin(Users users) {
        LinkedList<Article> listArticle = new LinkedList<>();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = null;
            sql = "select * from article where author_id = ? and delete_status = 1";
            st = conn.prepareStatement(sql);
            st.setInt(1,users.getId());
            rs = st.executeQuery();
            int i =0 ;
            while (rs.next()){
                listArticle.get(i).setId(rs.getInt("id"));
                listArticle.get(i).setTitle(rs.getString("title"));
                listArticle.get(i).setDeleteTime(rs.getDate("delete_time"));
                i++;
            }
        }catch (SQLException e){
            System.out.println("查询失败！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,rs);
            return listArticle;
        }

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
    public String[] selectKnowledgeBase(Users users, int flag,String[] storeKnowledgeName) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = null;
            sql = "select * from knowledgebase where `create_user_id` = ? and `category` =  ?";
            st = conn.prepareStatement(sql);
            st.setInt(1,users.getId());
            switch (flag){
                case 1:
                    st.setString(2,"个人知识库");
                    break;
                case 2:st.setString(2,"协作知识库");
                    break;
                default:
            }
            rs = st.executeQuery();
            for(int i=0;rs.next();i++){
                storeKnowledgeName[i] = rs.getString("knowledgebase_name");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,rs);
            return storeKnowledgeName;
        }

    }

    @Override
    public Integer selectIdByName(String name) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = null;

            sql = "select `id` from knowledgebase where knowledgebase_name = ?";
            st = conn.prepareStatement(sql);
            //预编译SQL，先写sql,然后不执行
            st.setString(1,name);
            //手动给参数赋值

            //注意点：sql/date   数据库       utils.Date  java    new Date().getTime() 获得时间戳
            rs = st.executeQuery();
            if(rs.next()){
                returnValue2 = rs.getInt("id");
            }else{
                returnValue2 = null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,rs);
            return returnValue2;
        }
    }
}
