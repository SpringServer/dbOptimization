package dbOptimization.servlet;

import com.alibaba.fastjson.JSON;
import dbOptimization.dao.UsersDao;
import dbOptimization.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectServlet",urlPatterns = "/SelectServlet")
public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDao usersDao = new UsersDao();
        List<User> users =usersDao.findAll();
        String jsonstr = JSON.toJSONString(users);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(jsonstr);
        System.out.println("select success author:molenChair");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
