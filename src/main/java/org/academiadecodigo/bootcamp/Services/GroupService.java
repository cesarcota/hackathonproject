package org.academiadecodigo.bootcamp.Services;

import org.academiadecodigo.bootcamp.Models.Category;
import org.academiadecodigo.bootcamp.Models.Group;
import org.academiadecodigo.bootcamp.Models.User;

import java.util.List;

public interface GroupService  extends Service{


    void addGroup(Group group);

    void addType(Category category, String name);

    void addUser(User user, String name);

    Group findGroup(String name);

    List<User> findAll();


}
