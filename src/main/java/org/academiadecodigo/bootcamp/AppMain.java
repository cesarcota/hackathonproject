package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Dao.GroupDao;
import org.academiadecodigo.bootcamp.Dao.JPAGroupDao;
import org.academiadecodigo.bootcamp.Dao.JPAUserDao;
import org.academiadecodigo.bootcamp.Dao.UserDao;
import org.academiadecodigo.bootcamp.Models.Group;
import org.academiadecodigo.bootcamp.Models.User;
import org.academiadecodigo.bootcamp.Persistence.JPASessionManager;
import org.academiadecodigo.bootcamp.Persistence.JPATransactionManager;
import org.academiadecodigo.bootcamp.Services.GroupService;
import org.academiadecodigo.bootcamp.Services.JPAGroupService;
import org.academiadecodigo.bootcamp.Services.JPAUserService;
import org.academiadecodigo.bootcamp.Services.UserService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.LinkedList;
import java.util.List;

public class AppMain implements ServletContextListener {




    @Override
    public void contextInitialized(ServletContextEvent sce){
        //Get the servlet context from context event
        ServletContext ctx = sce.getServletContext();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hackathon");
        //JPAUserDao. So, we create an object of these types, passing the session manager
        JPASessionManager session = new JPASessionManager(emf);
        JPATransactionManager transaction = new JPATransactionManager(session);
        UserDao userDao = new JPAUserDao(session);
        GroupDao groupDao = new JPAGroupDao(session);
        UserService userService= new JPAUserService(transaction,userDao);
        GroupService groupService = new JPAGroupService(transaction,groupDao);








        //Instantiate the objects and make the wire
        //UserService userService = new JPAUserService();
        //BootcampService bootcampService=new MockBootcampService();

        //Make the services available to all the app
        ctx.setAttribute("UserService",userService);

        //Add the users
        userService.addUser(new User("luis","12345","luis@gmail.com"));
        userService.addUser(new User("ana","12345","ana@gmail.com"));
        userService.addUser(new User("ricardo","12345","ricardo@hotmail.com"));

        User manel = new User("manel","12345","manel@gmail.com");
        Group test = new Group("Test");
        groupService.addGroup(test);
        //manel.addGroup(test);
        groupService.addUser(manel,"Test");


        /*
        User user = new User("cesar", "cesar", "cesar");
        //user.addGroup(new Group("group1"));
        userService.addUser(user);

        Group test = new Group("Test");
        groupService.addGroup(test);
        groupService.addUser(user,"Test");

*/

        //List<User> list = new LinkedList<>(groupService.findGroup("Test").getUsers());


        /*
        //This uses the JPA
        emf = Persistence.createEntityManagerFactory("academia_codigo");
        ServiceRegistry.getInstance().setEmf(emf);

        //Now we need to create the Session Manager, since it's the core. Plus, the reference of this session, must be the same to the JPATransaction and
        //JPAUserDao. So, we create an object of these types, passing the session manager
        JPASessionManager session = new JPASessionManager();
        JPATransactionManager transaction = new JPATransactionManager(session);
        JPAUserDao userDao = new JPAUserDao(session);
        JPABootcampDao bootcampDao = new JPABootcampDao(session);
        JPACodecadetDao cadetDao = new JPACodecadetDao(session);

        //Now we pass the reference of these objects to the registry, so it can be used in the other services
        ServiceRegistry.getInstance().setTransactionManager(transaction);
        ServiceRegistry.getInstance().setDao(JPAUserDao.class.getSimpleName(),userDao);
        ServiceRegistry.getInstance().setDao(JPABootcampDao.class.getSimpleName(),bootcampDao);
        ServiceRegistry.getInstance().setDao(JPACodecadetDao.class.getSimpleName(),cadetDao);

        */
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }


}
