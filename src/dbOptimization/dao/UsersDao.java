package dbOptimization.dao;

import dbOptimization.domain.User;
import dbOptimization.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsersDao {
    //添加对用户的操作
    public boolean insert(User user){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            // 获得数据的连接 conn
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO users(id,name,password,sex,age,birthday) VALUES (?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,user.getId());
            pstmt.setString(2,user.getName());
            pstmt.setString(3,user.getPassword());
            pstmt.setString(4,user.getSex());
            pstmt.setInt(5,user.getAge());
            pstmt.setDate(6,(java.sql.Date)user.getBirthday());
            int result = pstmt.executeUpdate();
            if (result>0)
                return true;
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,pstmt,conn);
        }
        return false;
    }

    // 查询所有的User对象
    public ArrayList<User> findAll(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>();
        try{
            // 获取数据连接
            conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM users";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            //处理结果集
            while (rs.next()){
                User user =new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirthday(rs.getDate("birthday"));
                list.add(user);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,pstmt,conn);
        }
        return null;
    }

    // 根据ID查找用户
    public User find(int id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM users WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs  = pstmt.executeQuery();
            while (rs.next()){
                User user =new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirthday(rs.getDate("birthday"));
                return user;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,pstmt,conn);
        }
        return null;
    }

    //删除用户
    public boolean delete(int id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "DELETE FROM users WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            int result = pstmt.executeUpdate();
            if(result!=0)
                return true;
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,pstmt,conn);
        }
        return false;
    }

    // 修改用户
    public boolean update(User user){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            String sql = "UPDATE users SET name=?,password=?,sex=?,age=?,birthday=? WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getSex());
            pstmt.setInt(4,user.getAge());
            pstmt.setDate(5,(java.sql.Date)user.getBirthday());
            pstmt.setInt(6,user.getId());
            int result = pstmt.executeUpdate();
            if(result!=0)
                return true;
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs,pstmt,conn);
        }
        return false;
    }
}
