package org.academiadecodigo.bootcamp.Models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    private String pass;
    private String email;
    private Integer id;
    @ManyToMany
    private Group group;

    public User(String username, String pass, String email){
        this.username=username;
        this.pass=pass;
        this.email = email;
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
        return group.equals(user.group);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + pass.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + group.hashCode();
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

}
