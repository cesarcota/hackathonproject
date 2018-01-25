package org.academiadecodigo.bootcamp.Services;

import org.academiadecodigo.bootcamp.Models.User;

import java.io.Serializable;
import java.util.List;

public interface UserService extends Service {

    boolean authenticate(String username, String pass);

    void addUser(User user);

    User findByName(String name);

    int count();

    List<User> listUsers();

}
