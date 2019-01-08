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

@WebServlet(name = "UpdateServlet",urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setId(Integer.valueOf("3"));
        user.setName("spring1");
        user.setPassword("12345678");
        user.setSex("boy");
        user.setAge(20);
        user.setBirthday(Date.valueOf("2019-1-8"));
        UsersDao usersDao = new UsersDao();
        if(usersDao.update(user)){
            System.out.println("update success author:molenChair");
            response.getWriter().println("update success");
        }else {
            System.out.println("update fail author:molenChair");
            response.getWriter().println("update fail");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
