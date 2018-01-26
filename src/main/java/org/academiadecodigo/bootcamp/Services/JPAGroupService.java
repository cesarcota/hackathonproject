package org.academiadecodigo.bootcamp.Services;

import org.academiadecodigo.bootcamp.Dao.GroupDao;
import org.academiadecodigo.bootcamp.Models.Category;
import org.academiadecodigo.bootcamp.Models.Group;
import org.academiadecodigo.bootcamp.Models.User;
import org.academiadecodigo.bootcamp.Persistence.TransactionManager;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import java.util.List;

public class JPAGroupService implements GroupService{

    private TransactionManager transaction;
    private GroupDao groupDao;

    public JPAGroupService( TransactionManager transaction,GroupDao groupDao){//
        this.transaction=transaction;
        this.groupDao=groupDao;
    }

    @Override
    public void addGroup(Group group) {

        if (group == null){
            return;
        }

        try{

            transaction.beginWrite();

            groupDao.saveOrUpdate(group);

            transaction.commit();

        }catch(RollbackException e){

            transaction.rollback();
        }

    }

    @Override
    public void addType(Category category, String name){

        Group group=findGroup(name);

        group.addCategory(category);

        try{

            transaction.beginWrite();

            groupDao.addType(category);

            transaction.commit();

        }catch(RollbackException e){

            transaction.rollback();
        }


    }

    @Override
    public void addUser(User user, String name) {

        Group group=findGroup(name);

        group.addUser(user);

        user.addGroup(group);

        try{

            transaction.beginWrite();

            groupDao.addUser(user);

            transaction.commit();

        }catch(RollbackException e){

            transaction.rollback();
        }

    }


    @Override
    public Group findGroup(String name) {


        transaction.beginRead();


        try {

            return groupDao.findByName(name);

        }catch (NoResultException e){

            return null;

        } finally {
            transaction.commit();
        }


    }

    @Override
    public List<User> findAll() {
        transaction.beginRead();

        try {

            return groupDao.findAll();

        }catch (NoResultException e){

            return null;

        } finally {
            transaction.commit();
        }

    }
}
