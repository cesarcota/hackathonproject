package org.academiadecodigo.bootcamp.Dao;

import org.academiadecodigo.bootcamp.Models.Category;
import org.academiadecodigo.bootcamp.Models.Group;
import org.academiadecodigo.bootcamp.Models.User;

import java.util.List;

public interface GroupDao extends Dao{

    void saveOrUpdate(Group group);

    void addType(Category category);

    void addUser(User user);

    Group findByName(String name);

    List<User> findAll();

}
