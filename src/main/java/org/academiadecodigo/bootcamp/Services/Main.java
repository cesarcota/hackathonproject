package org.academiadecodigo.bootcamp.Services;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.Dao.JPAUserDao;
import org.academiadecodigo.bootcamp.Models.User;
import org.academiadecodigo.bootcamp.Persistence.JPASessionManager;
import org.academiadecodigo.bootcamp.Persistence.JPATransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main extends Application{
    public static EntityManagerFactory emf;
    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("hackathon");
        //JPAUserDao. So, we create an object of these types, passing the session manager
        JPASessionManager session = new JPASessionManager(emf);
        JPATransactionManager transaction = new JPATransactionManager(session);
        JPAUserDao userDao = new JPAUserDao(session);
        JPAUserService userService= new JPAUserService(transaction, userDao);


        User cesar = new User("cesar", "cesar", "cesar@cesar.com");
        userService.addUser(cesar);
        userService.addUser(new User("luis","12345","luis@gmail.com"));
        userService.addUser(new User("ana","12345","ana@gmail.com"));
        userService.addUser(new User("ricardo","12345","ricardo@hotmail.com"));

        System.out.println("authenticate must be true: " + userService.authenticate("cesar@cesar.com", "cesar"));
        System.out.println("findByE-mail must return a user: " + userService.findByEmail(cesar.getEmail()).getEmail());







        emf.close();




    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
