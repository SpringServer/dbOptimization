package testDatabases;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "insertTableServlet",urlPatterns = "/insertTableServlet")
public class insertTableServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        Connection conn = null;
        try{
            //register databases
            Class.forName("com.mysql.jdbc.Driver");
            //connect databases
            String url ="jdbc:mysql://localhost:3306/javatest?useSSL=false";
            //login
            String username ="root";
            String password =null;
            //get databases connection
            conn =DriverManager.getConnection(url,username,password);
            // get pstmt object
            String sql = "INSERT INTO users(id,name,password,sex,age,birthday) VALUES (?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,2);
            pstmt.setString(2,"fyl");
            pstmt.setString(3,"123456");
            pstmt.setString(4,"girl");
            pstmt.setInt(5,19);
            pstmt.setDate(6,new Date(new java.util.Date().getTime()));
            int result = pstmt.executeUpdate();
            if(result!=0)
                System.out.println("insert success author:molenChair");
                response.getWriter().println("insert success");
        }catch (ClassNotFoundException e){
            //catch out problem
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            // reuse resources
            if(rs!=null){
                try{
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                rs=null;
            }
            if(pstmt!=null){
                try{
                    pstmt.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
                pstmt=null;
            }
            if (conn!=null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                conn=null;
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
