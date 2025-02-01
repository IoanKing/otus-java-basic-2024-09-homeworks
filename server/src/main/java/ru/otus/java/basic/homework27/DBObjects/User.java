package ru.otus.java.basic.homework27.DBObjects;

import java.util.List;
import java.util.Objects;

public class User {
    private int id;
    private String password;
    private String email;
    private String userName;
    private List<Role> roles;

    public User(int id, String password, String email, String userName) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, email, userName);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
