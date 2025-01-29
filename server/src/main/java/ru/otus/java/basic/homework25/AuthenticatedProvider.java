package ru.otus.java.basic.homework25;

public interface AuthenticatedProvider {
    void initialize();
    boolean authenticate(ClientHandler clientHandler, String login, String password );
    boolean registration(ClientHandler clientHandler, String login, String password, String username, Roles role);
}
