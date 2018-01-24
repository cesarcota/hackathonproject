package org.academiadecodigo.bootcamp.Controllers;

import org.academiadecodigo.bootcamp.Services.JPAUserService;
import org.academiadecodigo.bootcamp.Services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create request dispatcher wrappers around the views
        RequestDispatcher page1Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");

        page1Dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("username");
        String pass= req.getParameter("password");
        String message;

        userService=(JPAUserService)getServletContext().getAttribute("UserService");

        if(userService.authenticate(name,pass)==false){
            message="Sorry, "+name+" does not exist, or password is not correct";
            req.setAttribute("message",message);

            RequestDispatcher page1Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
            page1Dispatcher.forward(req,resp);

        }else{

            String buttonName="Users";
            req.getSession().setAttribute("name",name);
            req.getSession().setAttribute("buttonName",buttonName);

            //Save the user for this session
            req.getSession().setAttribute("user",userService.findByName(name));

            resp.sendRedirect("/webBootcamp/bootcamp");


        }



    }
}
