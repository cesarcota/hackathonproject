package org.academiadecodigo.bootcamp.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String username;
    private String pass;
    private String email;
    @ManyToMany(
            fetch = FetchType.EAGER
    )
    private Set<Group> groups;



    public User(String username, String pass, String email){
        this.username=username;
        this.pass=pass;
        this.email = email;
        this.groups = new HashSet<>();
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        if (!pass.equals(user.pass)) return false;
        if (!email.equals(user.email)) return false;
        if (!id.equals(user.id)) return false;
        return groups.equals(user.groups);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + pass.hashCode();
        result = 31 * result + email.hashCode();
        //result = 31 * result + id.hashCode();
        result = 31 * result + groups.hashCode();
        return result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String password) {
        this.pass = pass;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }


}
