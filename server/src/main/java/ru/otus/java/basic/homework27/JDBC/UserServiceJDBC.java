package ru.otus.java.basic.homework27.JDBC;

import ru.otus.java.basic.homework27.ClientHandler;
import ru.otus.java.basic.homework27.DBObjects.User;
import ru.otus.java.basic.homework27.Roles;

import java.util.List;

public interface UserServiceJDBC {
    List<User> getAll();

    boolean isAdmin(int userId);
    boolean authenticate(ClientHandler clientHandler, String email, String password);
    boolean registration(String email, String password, int role);
}
