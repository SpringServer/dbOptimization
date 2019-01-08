package dbOptimization.servlet;

import dbOptimization.dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet",urlPatterns = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf("3");
        UsersDao usersDao = new UsersDao();
        if(usersDao.delete(id)){
            System.out.println("delete success author:molenChair");
            response.getWriter().println("delete success");
        }else{
            System.out.println("delete success author:molenChair");
            response.getWriter().println("delete success");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
