package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Dao.JPAUserDao;
import org.academiadecodigo.bootcamp.Dao.UserDao;
import org.academiadecodigo.bootcamp.Models.User;
import org.academiadecodigo.bootcamp.Persistence.JPASessionManager;
import org.academiadecodigo.bootcamp.Persistence.JPATransactionManager;
import org.academiadecodigo.bootcamp.Services.JPAUserService;
import org.academiadecodigo.bootcamp.Services.UserService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppMain implements ServletContextListener {




    @Override
    public void contextInitialized(ServletContextEvent sce){
        //Get the servlet context from context event
        ServletContext ctx = sce.getServletContext();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hackathon");
        //JPAUserDao. So, we create an object of these types, passing the session manager
        JPASessionManager session = new JPASessionManager(emf);
        JPATransactionManager transaction = new JPATransactionManager(session);
        JPAUserDao userDao = new JPAUserDao(session);
        JPAUserService userService= new JPAUserService(transaction,userDao);






        //Instantiate the objects and make the wire
        //UserService userService = new JPAUserService();
        //BootcampService bootcampService=new MockBootcampService();

        //Make the services available to all the app
        ctx.setAttribute("UserService",userService);

        //Add the users
        userService.addUser(new User("luis","12345","luis@gmail.com"));
        userService.addUser(new User("ana","12345","ana@gmail.com"));
        userService.addUser(new User("ricardo","12345","ricardo@hotmail.com"));


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
