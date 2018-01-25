package org.academiadecodigo.bootcamp.Dao;


import org.academiadecodigo.bootcamp.Models.User;

public interface UserDao extends Dao {


    void saveOrUpdate(User user);

    User findByName(String name);

    int count();

}
