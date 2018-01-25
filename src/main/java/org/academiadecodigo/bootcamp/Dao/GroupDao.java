package org.academiadecodigo.bootcamp.Dao;

import jdk.jfr.Category;
import org.academiadecodigo.bootcamp.Models.User;

import java.util.List;

public interface GroupDao extends Dao{

    void saveOrUpdate(Group group);

    void addType(List<Group> groupTypes);

    Group findById(Integer id);

    List<User> findAll();

}
