package org.academiadecodigo.bootcamp.Controllers;

import org.academiadecodigo.bootcamp.Models.Group;
import org.academiadecodigo.bootcamp.Services.GroupService;
import org.academiadecodigo.bootcamp.Services.JPAGroupService;
import org.academiadecodigo.bootcamp.Services.JPAUserService;
import org.academiadecodigo.bootcamp.Services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DashboardController extends HttpServlet {

    private GroupService userService;
    private RequestDispatcher pageDispatcher;

    @Override
    public void init() throws ServletException {

        pageDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/dashboard.jsp");
        this.userService = (JPAGroupService) getServletContext().getAttribute("GroupService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object user = req.getSession().getAttribute("user");

        if (user == null){
            pageDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
            pageDispatcher.forward(req,resp);
            return;
        }
        pageDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {





    }


}
