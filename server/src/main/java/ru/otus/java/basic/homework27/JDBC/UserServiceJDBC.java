package ru.otus.java.basic.homework27.JDBC;

import ru.otus.java.basic.homework27.ClientHandler;
import ru.otus.java.basic.homework27.DBObjects.Role;
import ru.otus.java.basic.homework27.DBObjects.User;

import java.util.List;

public interface UserServiceJDBC {
    boolean isAdmin(int userId);
    boolean authenticate(ClientHandler clientHandler, String email, String password);
    boolean registration(ClientHandler clientHandler, String email, String password, String userName, String role);
}
