package org.academiadecodigo.bootcamp.Controllers;


import org.academiadecodigo.bootcamp.Models.User;
import org.academiadecodigo.bootcamp.Services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BootcampController extends HttpServlet {

    private String buttonName = "Users";
    private String requestType = "Bootcamps";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("ENTERED HERE!");

        if (req.getParameter("list") != null) {
            if (buttonName.equals("Users")) {
                buttonName = "Bootcamps";
                requestType = "Users";
            } else {
                buttonName = "Users";
                requestType = "Bootcamps";

            }
            req.setAttribute("buttonName", buttonName);

            loadInfo(req, resp, requestType);

        }

        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/webBootcamp");
        } else {
            //RequestDispatcher page1Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/bootcamp.jsp");


            //page1Dispatcher.forward(req,resp);

            loadInfo(req, resp, requestType);

        }


    }

    private void loadInfo(HttpServletRequest req, HttpServletResponse resp, String attribute) throws ServletException, IOException {

        if (attribute.equals("Users")) {
            UserService userService = (MockUserService) getServletContext().getAttribute("UserService");

            List<User> userList = userService.listUsers();

            req.setAttribute("usersList", userList);

        } else {

            BootcampService bootcampService = (MockBootcampService) getServletContext().getAttribute("BootcampService");

            List<Bootcamp> bootcampList = bootcampService.listBootcamps();

            req.setAttribute("bootcamps", bootcampList);

        }

        RequestDispatcher page1Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/bootcamp.jsp");
        page1Dispatcher.forward(req, resp);


    }


}
