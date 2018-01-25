package org.academiadecodigo.bootcamp.Services;

import org.academiadecodigo.bootcamp.Dao.JPAGroupDao;
import org.academiadecodigo.bootcamp.Dao.JPAUserDao;
import org.academiadecodigo.bootcamp.Models.User;
import org.academiadecodigo.bootcamp.Persistence.JPATransactionManager;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import java.util.List;

public class JPAGroupService implements GroupService{

    private JPATransactionManager transaction;
    private JPAGroupDao groupDao;

    public JPAGroupService( JPATransactionManager transaction,JPAGroupDao groupDao){//
        this.transaction=transaction;
        this.groupDao=groupDao;
    }

    @Override
    public void addGroup(Group group) {

        try{

            transaction.beginWrite();

            groupDao.saveOrUpdate(group);

            transaction.commit();

        }catch(RollbackException e){

            transaction.rollback();
        }

    }

    @Override
    public void addType(Category category, Integer id){

        Group group=findGroup(id);

        group.setType(category);

        try{

            transaction.beginWrite();

            groupDao.addType(group.getType());

            transaction.commit();

        }catch(RollbackException e){

            transaction.rollback();
        }


    }


    @Override
    public Group findGroup(Integer id) {


        transaction.beginRead();


        try {

            return groupDao.findById(id);

        }catch (NoResultException e){

            return null;

        } finally {
            transaction.commit();
        }

        return null;
    }

    @Override
    public List<User> findUser() {
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
