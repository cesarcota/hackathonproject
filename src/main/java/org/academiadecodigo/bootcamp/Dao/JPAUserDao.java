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
    public void saveOrUpdate(User user) {

            session.getCurrentSession().merge(user);
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
