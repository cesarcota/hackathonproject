package org.academiadecodigo.bootcamp.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;


    @OneToMany(fetch = FetchType.EAGER)
    private Set<Category> categories=new HashSet<Category>();

    @OneToMany
    private Set<User> users = new HashSet<>();

    public Group(String name) {
        this.name = name;
    }

    public Group() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!id.equals(group.id)) return false;
        if (!name.equals(group.name)) return false;
        return users.equals(group.users);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + users.hashCode();
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addCategory(Category category){
        this.categories.add(category);
    }
    public Set<Category> getCategories() {
        return categories;
    }


}
