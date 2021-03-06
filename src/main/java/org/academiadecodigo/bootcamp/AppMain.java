package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Models.User;
import org.academiadecodigo.bootcamp.Services.JPAUserService;
import org.academiadecodigo.bootcamp.Services.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppMain implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce){
        //Get the servlet context from context event
        ServletContext ctx = sce.getServletContext();

        //Instantiate the objects and make the wire
        UserService userService=new JPAUserService();
        //BootcampService bootcampService=new MockBootcampService();

        //Make the services available to all the app
        ctx.setAttribute("UserService",userService);

        //Add the users
        userService.addUser(new User("luis","12345"));
        userService.addUser(new User("ana","12345"));
        userService.addUser(new User("ricardo","12345"));


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
