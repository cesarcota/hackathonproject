package org.academiadecodigo.bootcamp.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer groupId;
    private String groupName;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;


    @OneToMany(fetch = FetchType.EAGER)
    private Set<Category> categories=new HashSet<Category>();

    @OneToMany
    private Set<User> users = new HashSet<>();

    public Group(String name) {
        this.groupName = name;
    }

    public Group() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (!groupId.equals(group.groupId)) return false;
        if (!groupName.equals(group.groupName)) return false;
        return users.equals(group.users);
    }

    @Override
    public int hashCode() {
        int result = groupId.hashCode();
        result = 31 * result + groupName.hashCode();
        result = 31 * result + users.hashCode();
        return result;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer id) {
        this.groupId = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String name) {
        this.groupName = name;
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

    public void addUser(User user){
        this.users.add(user);
    }

    public Set<Category> getCategories() {
        return categories;
    }


}
