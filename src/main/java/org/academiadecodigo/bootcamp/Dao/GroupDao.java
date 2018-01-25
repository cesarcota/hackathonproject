package org.academiadecodigo.bootcamp.Dao;

import org.academiadecodigo.bootcamp.Models.Category;
import org.academiadecodigo.bootcamp.Models.Group;
import org.academiadecodigo.bootcamp.Models.Type;
import org.academiadecodigo.bootcamp.Models.User;

import java.util.List;
import java.util.Set;

public interface GroupDao extends Dao{

    void saveOrUpdate(Group group);

    void addType(Category category);

    Group findById(Integer id);

    List<User> findAll();

}
