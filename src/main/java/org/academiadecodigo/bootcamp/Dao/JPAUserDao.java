package org.academiadecodigo.bootcamp.Dao;


import org.academiadecodigo.bootcamp.Models.User;
import org.academiadecodigo.bootcamp.Persistence.JPASessionManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


public class JPAUserDao implements UserDao  {


    private JPASessionManager session;

    @PersistenceContext
    private EntityManager em;

    public JPAUserDao(JPASessionManager session){//
        this.session=session;
    }

    @Override
    public boolean authenticate(String pass) {

        TypedQuery<User> query = session.getCurrentSession().createQuery("SELECT user FROM User user WHERE user.password = :pass", User.class);
        //TypedQuery<User> query = em.createQuery("SELECT user FROM User user WHERE user.password = :pass", User.class);

        query.setParameter("pass", pass);
        return true;
    }

    @Override
    public void saveOrUpdate(User user) {

        //It needs to check if the bootcamp already exists
        User tempUser=session.getCurrentSession().find(User.class, user.getName());
        //User tempUser=em.find(User.class, user.getUsername());

        if(tempUser==null){

            session.getCurrentSession().merge(user);
            //em.merge(user);


        }else{

            System.out.println("There is already this user in the system");
        }

    }



    @Override
    public User findByName(String name) {

        TypedQuery<User> query = session.getCurrentSession().createQuery("SELECT user FROM User user WHERE user.username = :name", User.class);
        //TypedQuery<User> query = em.createQuery("SELECT user FROM User user WHERE user.username = :name", User.class);

        query.setParameter("name", name);

        return query.getSingleResult();
    }

    @Override
    public int count() {
        TypedQuery<User> query = session.getCurrentSession().createQuery("SELECT user  FROM User user", User.class);
        //TypedQuery<User> query = em.createQuery("SELECT user  FROM User user", User.class);


        return query.getResultList().size();
    }
}
