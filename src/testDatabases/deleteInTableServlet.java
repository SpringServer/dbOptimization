package testDatabases;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "deleteInTableServlet",urlPatterns = "/deleteInTable")
public class deleteInTableServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PreparedStatement pstmt =null;
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
            conn = DriverManager.getConnection(url,username,password);
            // get pstmt object
            String sql = "DELETE FROM users where id =?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,2);
            int result = pstmt.executeUpdate();
            if(result!=0)
                System.out.println("delete success author:molenChair");
                response.getWriter().println("delete success");
        }catch (ClassNotFoundException e){
            //catch out problem
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {

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
        doPost(request,response);
    }
}
