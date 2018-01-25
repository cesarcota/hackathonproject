package org.academiadecodigo.bootcamp.Services;

import org.academiadecodigo.bootcamp.Models.User;

import java.io.Serializable;
import java.util.List;

public interface UserService extends Service {

    boolean authenticate(String email, String pass);

    void addUser(User user);

    User findByName(String name);

    User findByEmail(String email);

    int count();

    List<User> listUsers();

}
