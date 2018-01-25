package org.academiadecodigo.bootcamp.Dao;


import org.academiadecodigo.bootcamp.Models.Category;
import org.academiadecodigo.bootcamp.Models.Group;
import org.academiadecodigo.bootcamp.Models.Type;
import org.academiadecodigo.bootcamp.Models.User;
import org.academiadecodigo.bootcamp.Persistence.JPASessionManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

public class JPAGroupDao implements GroupDao{

    private JPASessionManager session;

    @PersistenceContext
    private EntityManager em;


    @Override
    public void saveOrUpdate(Group group) {

        session.getCurrentSession().merge(group);

    }

    @Override
    public void addType(Category category){

        session.getCurrentSession().merge(category);

    }

    @Override
    public Group findById(Integer id) {
        TypedQuery<Group> query = session.getCurrentSession().createQuery("SELECT group FROM Group group WHERE group.id = :id", Group.class);
        //TypedQuery<User> query = em.createQuery("SELECT user FROM User user WHERE user.password = :pass", User.class);

        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public List<User> findAll(){

        TypedQuery<User> query = session.getCurrentSession().createQuery("SELECT user  FROM User user", User.class);
        //TypedQuery<User> query = em.createQuery("SELECT user  FROM User user", User.class);


        return query.getResultList();
    }


}
