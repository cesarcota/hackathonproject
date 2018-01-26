package org.academiadecodigo.bootcamp.Services;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.Dao.GroupDao;
import org.academiadecodigo.bootcamp.Dao.JPAGroupDao;
import org.academiadecodigo.bootcamp.Dao.JPAUserDao;
import org.academiadecodigo.bootcamp.Dao.UserDao;
import org.academiadecodigo.bootcamp.Models.Category;
import org.academiadecodigo.bootcamp.Models.Group;
import org.academiadecodigo.bootcamp.Models.Type;
import org.academiadecodigo.bootcamp.Models.User;
import org.academiadecodigo.bootcamp.Persistence.JPASessionManager;
import org.academiadecodigo.bootcamp.Persistence.JPATransactionManager;
import org.academiadecodigo.bootcamp.Persistence.TransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main extends Application{
    public static EntityManagerFactory emf;
    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("hackathon");
        //JPAUserDao. So, we create an object of these types, passing the session manager
        JPASessionManager session = new JPASessionManager(emf);
        TransactionManager transaction = new JPATransactionManager(session);
        UserDao userDao = new JPAUserDao(session);
        GroupDao groupDao = new JPAGroupDao(session);
        UserService userService= new JPAUserService(transaction,userDao);
        GroupService groupService = new JPAGroupService(transaction,groupDao);




        userService.addUser(new User("cesar","12345","luis@gmail.com"));
        userService.addUser(new User("brandao","12345","ana@gmail.com"));
        userService.addUser(new User("angelo","12345","ricardo@hotmail.com"));

        Group cagoes = new Group("Cagoes");
        Group yes = new Group("Yes");
        groupService.addGroup(new Group("Marretas"));
        groupService.addGroup(new Group("Baroes"));
        groupService.addGroup(cagoes);

        System.out.println("NAME "+cagoes.getName());
        System.out.println("ID "+cagoes.getId());
        System.out.println("ID "+yes.getId());

        Category beer = new Category(Type.BEER);
        groupService.addType(beer,cagoes.getId());


        emf.close();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
