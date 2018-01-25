package org.academiadecodigo.bootcamp.Services;

import org.academiadecodigo.bootcamp.Models.User;

import java.util.List;

public interface GroupService  extends Service{


    void addGroup(Group group);

    void addType(Category category, Integer id);

    Group findGroup(Integer id);

    List<User> findUser();


}