package org.academiadecodigo.bootcamp.Services;

import org.academiadecodigo.bootcamp.Dao.JPAUserDao;
import org.academiadecodigo.bootcamp.Models.User;
import org.academiadecodigo.bootcamp.Persistence.JPATransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import java.util.List;

@Transactional
public class JPAUserService implements UserService {

    private JPATransactionManager transaction;
    private JPAUserDao userDao;

    public JPAUserService( JPATransactionManager transaction,JPAUserDao userDao){//
        this.transaction=transaction;
        this.userDao=userDao;
    }

    public JPAUserService() {
    }

    @Override
    public boolean authenticate(String username,String pass) {

        try {

            transaction.beginRead();

            userDao.authenticate(pass);

            return true;

        }catch (NoResultException e){

            return false;

        } finally {
            transaction.commit();
        }

    }

    @Override
    public void addUser(User user) {

        try{

            transaction.beginWrite();

            userDao.saveOrUpdate(user);

            transaction.commit();

        }catch(RollbackException e){
            System.err.println("Couldn't finish the transaction. Proceed to the rollback");
            transaction.rollback();
        }



    }

    @Override
    public User findByName(String name) {

        transaction.beginRead();

        try {

            return userDao.findByName(name);

        }catch (NoResultException e){

            return null;

        } finally {
            transaction.commit();
        }


    }

    @Override
    public int count() {

        transaction.beginRead();

        try {

            return userDao.count();


        }catch (NoResultException e){

            return  0;

        } finally {
            transaction.commit();
        }
    }

    @Override
    public List<User> listUsers() {
        return null;
    }


}