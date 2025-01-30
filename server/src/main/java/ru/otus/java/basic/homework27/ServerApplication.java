package ru.otus.java.basic.homework27;

import java.sql.SQLException;

public class ServerApplication {
    public static void main(String[] args) {
        try {
            new Server(8189).start();
        } catch (SQLException e) {
            System.err.println("Ошибка при подключении к БД: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}