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
    public LinkedList<Article> selectArticle(Integer id) {
        LinkedList<Article> listArticle = new LinkedList<>();
      Connection conn = null;
      PreparedStatement st = null;
      ResultSet rs = null;
      try{
          conn = JdbcUtils_DBCP.getConnection();
          String sql = null;
          sql = "select * from article where knowbase_id = ? and delete_status = 0";
          st = conn.prepareStatement(sql);
          st.setInt(1,id);
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
    public LinkedList<String > selectKnowledgeBase(int id,int item) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        LinkedList<String> listKnowledgeBase = new LinkedList<>();
        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = null;
            sql = "select * from knowledgebase where `create_user_id` = ? and category = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1,id);
            switch (item){
                case 5:
                    st.setString(2,"个人知识库");
                    break;
                case 7:st.setString(2,"协作知识库");
                    break;
                default:
            }
            rs = st.executeQuery();
            for(int i=0;rs.next();i++){
                 listKnowledgeBase.add(rs.getString("knowledgebase_name"));
            }
        }catch (SQLException e){
            if(item == 5){
                System.out.println("您暂无个人知识库！");
            }
            if(item == 7){
                System.out.println("您暂无协作知识库！");
            }
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,rs);
            return listKnowledgeBase;
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
            st.setString(1,name);
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

    @Override
    public LinkedList<Team> selectManageTeam(Users users) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        LinkedList<Team> listTeam = new LinkedList<>();

        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = "select * from team where create_user_id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1,users.getId());
            rs = st.executeQuery();
            while(rs.next()){
                Team team = new Team();
                team.setId(rs.getInt("id"));
                team.setTeam_name(rs.getString("team_name"));
                team.setCreate_user_id(rs.getInt("create_user_id"));
                team.setInvitationCode1(rs.getString("invitationCode1"));
                team.setInvitationCode2(rs.getString("invitationCode2"));
                team.setInvitationCode3(rs.getString("invitationCode3"));
                listTeam.add(team);
            }
        }catch (SQLException e){
            System.out.println("您暂无管理的团队！请先创建团队。");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,rs);
            return listTeam;
        }
    }

    @Override
    public LinkedList<Team> selectJoinTeam(Users users) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        LinkedList<Team> listTeam = new LinkedList<>();

        try{
            conn = JdbcUtils_DBCP.getConnection();
            String sql = "select team_id,team_name from member where member_id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1,users.getId());
            rs = st.executeQuery();
            while(rs.next()){
                Team team = new Team();
                team.setId(rs.getInt("team_id"));
                team.setTeam_name(rs.getString("team_name"));
//                team.setCreate_user_id(rs.getInt("create_user_id"));
//                team.setInvitationCode1(rs.getString("invitationCode1"));
//                team.setInvitationCode2(rs.getString("invitationCode2"));
//                team.setInvitationCode3(rs.getString("invitationCode3"));
                listTeam.add(team);
            }
        }catch (SQLException e){
            System.out.println("您暂无加入的团队！请先加入团队。");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,rs);
            return listTeam;
        }
    }

    @Override
    public LinkedList<Member> selectMember(Team team) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        LinkedList<Member> listMember = new LinkedList<>();

        try{
            conn = JdbcUtils_DBCP.getConnection();

                String sql = "select * from member where team_id = ?";
                st = conn.prepareStatement(sql);
                st.setInt(1,team.getId());
                rs = st.executeQuery();
                while(rs.next()){
                    Member member = new Member(rs.getInt("member_id"),rs.getInt("member_permission"),rs.getInt("knowledgebase_id"),rs.getString("knowledgebase_name"),rs.getString("member_name"));
                    listMember.add(member);

                }

        }catch (SQLException e){
           // System.out.println("您的团队暂无协作知识库！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,rs);
            return listMember;
        }
    }

    @Override
    public int selectPermission(Team team, Users users) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
       // LinkedList<Member> listMember = new LinkedList<>();
        int permission = 1;
        try{
            conn = JdbcUtils_DBCP.getConnection();

            String sql = "select member_permission from member where team_id = ? and member_id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1,team.getId());
            st.setInt(2,users.getId());
            rs = st.executeQuery();
            if(rs.next()){
                    permission = rs.getInt("member_permission");
            }

        }catch (SQLException e){
           // System.out.println("您的团队暂无协作知识库！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,rs);
            return permission;
        }
    }

    @Override
    public Article selectArticleContent(Article article) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Article article1 = new Article();
        // LinkedList<Member> listMember = new LinkedList<>();
       // int permission = 1;
        try{
            conn = JdbcUtils_DBCP.getConnection();

            String sql = "select content,title from article where id = ? ";
            st = conn.prepareStatement(sql);
            st.setInt(1,article.getId());

         //   st.setInt(2,users.getId());
            rs = st.executeQuery();
            if(rs.next()){
                article1.setContent(rs.getString("content"));
                article1.setTitle(rs.getString("title"));
            }

        }catch (SQLException e){
            System.out.println("文档为空！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,rs);
            return article1;
        }
    }

    @Override
    public Member selectIvCode(String input,Users users) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Member member = new Member();
        try{
            conn = JdbcUtils_DBCP.getConnection();

            String sql = "select invitationCode1,invitationCode2,invitationCode3,team_id from team ";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                if(rs.getString("invitationCode1").equals(input)){
                    member.setMember_id(users.getId());
                    member.setMember_permission(1);
                    member.setTeam_id(rs.getInt("team_id"));
                    break;
                }
                if(rs.getString("invitationCode2").equals(input)){
                    member.setMember_id(users.getId());
                    member.setMember_permission(2);
                    member.setTeam_id(rs.getInt("team_id"));
                    break;
                }
                if(rs.getString("invitationCode3").equals(input)){
                    member.setMember_id(users.getId());
                    member.setMember_permission(3);
                    member.setTeam_id(rs.getInt("team_id"));
                    break;
                }
            }

        }catch (SQLException e){
            System.out.println("邀请码错误！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,rs);
            return member;
        }
    }

    @Override
    public String selectCode(Team team,int permission) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String returnValue = null;
        try{
            conn = JdbcUtils_DBCP.getConnection();

            String sql = "select invitationCode1,invitationCode2,invitationCode3 from team where id = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1,team.getId());
            rs = st.executeQuery();
            if(rs.next()){
                switch (permission){
                    case 1:returnValue = rs.getString("invitationCode1");break;
                    case 2:returnValue = rs.getString("invitationCode2");break;
                    case 3:returnValue = rs.getString("invitationCode3");break;
                    default:
                }
            }

        }catch (SQLException e){
            System.out.println("邀请码错误！");
            e.printStackTrace();
        }finally{
            JdbcUtils_DBCP.release(conn,st,rs);
            return returnValue;
        }
    }

    @Override
    public LinkedList<Article> selectSharedArticle() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        LinkedList<Article> list = new LinkedList<>();
        try {
            conn = JdbcUtils_DBCP.getConnection();
            String sql = "select * from article where shared = 1 and delete_status = 0 order by `like` DESC ";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Article article = new Article(rs.getInt("id"),rs.getString("title"),
                        rs.getString("content"),rs.getDate("create_time"),
                        rs.getDate("update_time"),rs.getInt("like"),
                        rs.getInt("favorite"),rs.getString("comment"),
                        rs.getString("tag"));
                list.add(article);
            }

        } catch (SQLException e) {
            System.out.println("错误！");
            e.printStackTrace();
        } finally {
            JdbcUtils_DBCP.release(conn, st, rs);
            return list;
        }
    }
}
