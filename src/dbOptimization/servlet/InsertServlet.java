package dbOptimization.servlet;

import dbOptimization.dao.UsersDao;
import dbOptimization.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "InsertServlet",urlPatterns = "/InsertServlet")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setId(Integer.valueOf("3"));
        user.setName("spring");
        user.setPassword("123456");
        user.setSex("boy");
        user.setAge(20);
        user.setBirthday(Date.valueOf("2019-1-8"));
        UsersDao usersDao = new UsersDao();
        if(usersDao.insert(user)){
            System.out.println("insert success author:molenChair");
            response.getWriter().println("insert success");
        }else {
            System.out.println("insert fail author:molenChair");
            response.getWriter().println("insert fail");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
