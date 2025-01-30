package ru.otus.java.basic.homework27;

import ru.otus.java.basic.homework27.DBObjects.User;
import ru.otus.java.basic.homework27.JDBC.UserServiceJDBC;
import ru.otus.java.basic.homework27.JDBC.UserServiceJDBCImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            UserServiceJDBC userServiceJDBC = new UserServiceJDBCImpl();
            List<User> users = userServiceJDBC.getAll();
            System.out.println("userServiceJDBC.getAll() = " + userServiceJDBC.getAll());
            for (User user : users) {
                System.out.println("Пользователь с id = " + user.getId()
                        + " является администратором?\n"
                        + userServiceJDBC.isAdmin(user.getId())
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}