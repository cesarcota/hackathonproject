package org.academiadecodigo.bootcamp.Controllers;

import org.academiadecodigo.bootcamp.Services.JPAUserService;
import org.academiadecodigo.bootcamp.Services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {


    private UserService  userService;
    private RequestDispatcher page1Dispatcher;

    @Override
    public void init() throws ServletException {
        page1Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
        this.userService = (JPAUserService) getServletContext().getAttribute("UserService");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        page1Dispatcher.forward(request, response);
    }
}
