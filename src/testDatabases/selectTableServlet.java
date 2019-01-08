package testDatabases;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "selectTableServlet",urlPatterns = "/selectTableServlet")
public class selectTableServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Statement stmt =null;
        ResultSet rs = null;
        Connection conn = null;
        try{
            //register databases
            Class.forName("com.mysql.jdbc.Driver");
            //connect databases
            String url ="jdbc:mysql://localhost:3306/javatest";
            //login
            String username ="root";
            String password =null;
            //get databases connection
            conn =DriverManager.getConnection(url,username,password);
            //get Statement
            stmt = conn.createStatement();
            String sql = "select * from users";
            //use Statement object
            rs = stmt.executeQuery(sql);
            //search resources result
            System.out.println("id|name|password|sex|age|birthday");
            while (rs.next()){
                int id =rs.getInt("id");
                String name = rs.getString("name");
                String psd = rs.getString("password");
                String sex = rs.getString("sex");
                int age = rs.getInt("age");
                Date birthday = rs.getDate("birthday");
                System.out.println(id+"|"+name+"|"+psd+"|"+sex+"|"+age+"|"+birthday);
            }
            //out resources
            rs.close();
            stmt.close();
            conn.close();
        }catch (Exception e){
            //catch out problem
            e.printStackTrace();
        }finally {

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
