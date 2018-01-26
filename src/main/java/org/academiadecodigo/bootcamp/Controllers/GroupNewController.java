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

public class GroupNewController extends HttpServlet {

    private GroupService groupService;
    private RequestDispatcher page1Dispatcher;

    @Override
    public void init() throws ServletException {
        page1Dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/group-new.jsp");
        this.groupService = (JPAGroupService) getServletContext().getAttribute("GroupService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        page1Dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String groupId = req.getParameter("groupId");
        String groupName = req.getParameter("groupName");



        groupService.addGroup(new Group(groupId));

    }


}
