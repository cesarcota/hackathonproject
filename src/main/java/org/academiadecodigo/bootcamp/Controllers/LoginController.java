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
    private RequestDispatcher page1Dispatcher;

    @Override
    public void init() throws ServletException {
        page1Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
        this.userService = (JPAUserService) getServletContext().getAttribute("UserService");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create request dispatcher wrappers around the views
        page1Dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String pass = req.getParameter("password");
        String message;

        if (email.isEmpty() || pass.isEmpty()) {
            page1Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
            page1Dispatcher.forward(req, resp);
            return;
        }
        if (!userService.authenticate(email, pass)) {
            message = "Sorry, " + email + " does not exist, or password is not correct";
            req.setAttribute("message", message);
            page1Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
            page1Dispatcher.forward(req, resp);
            return;
        }


        //Save the user for this session
        req.getSession().setAttribute("user", userService.findByEmail(email));


        page1Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
        page1Dispatcher.forward(req, resp);


    }
}
