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
    public boolean authenticate(String email, String pass) {
        User user = findByEmail(email);
        if (user == null){
        return false;
        }
        return user.getEmail().equals(email) && user.getPassword().equals(pass);
    }

    @Override
    public void addUser(User user) {
        if (user == null){
            return;
        }
        if (findByName(user.getName()) != null){
            return;
        }
        if (findByEmail(user.getEmail()) != null){
            return;
        }
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

        if (name.isEmpty() || name == null){
            return null;
        }
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
    public User findByEmail(String email) {
        if (email.isEmpty() || email == null){
            return null;
        }
        transaction.beginRead();
        try {
            return userDao.findByName(email);
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




}