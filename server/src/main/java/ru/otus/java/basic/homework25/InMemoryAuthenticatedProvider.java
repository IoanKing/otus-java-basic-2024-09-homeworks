package ru.otus.java.basic.homework25;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryAuthenticatedProvider implements AuthenticatedProvider {

    private class User {
        private String login;
        private String password;
        private String username;
        private Roles role;

        public User(String login, String password, String username, Roles role) {
            this.login = login;
            this.password = password;
            this.username = username;
            this.role = role;
        }
    }

    private List<User> users;
    private Server server;

    public InMemoryAuthenticatedProvider(Server server) {
        this.server = server;
        this.users = new CopyOnWriteArrayList<>();
        users.add(new User("admin", "admin", "admin", Roles.ADMIN));
        users.add(new User("user1", "user1", "user1", Roles.USER));
        users.add(new User("user2", "user2", "user2", Roles.USER));
    }

    @Override
    public void initialize() {
        System.out.println("Инициализация InMemoryAuthenticatedProvider");
    }

    private String getUsernameByLoginAndPassword(String login, String password) {
        for (User u : users) {
            if (u.login.equals(login) && u.password.equals(password)) {
                return u.username;
            }
        }
        return null;
    }

    private Roles getRoleByUserName(String userName) {
        for (User u : users) {
            if (u.username.equals(userName)) {
                return u.role;
            }
        }
        return null;
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        String authUsername = getUsernameByLoginAndPassword(login, password);
        Roles userRole = getRoleByUserName(authUsername);
        if (authUsername == null) {
            clientHandler.sendMsg("Неверный логин/пароль");
            return false;
        }
        if (server.isUsernameBusy(authUsername)) {
            clientHandler.sendMsg("Указанная учетная запись уже занята");
            return false;
        }
        clientHandler.setUsername(authUsername);
        clientHandler.setRole(userRole);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/authok " + authUsername);

        return true;
    }

    private boolean isLoginAlreadyExists(String login) {
        for (User u : users) {
            if (u.login.equals(login)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUsernameAlreadyExists(String username) {
        for (User u : users) {
            if (u.username.equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean registration(ClientHandler clientHandler, String login, String password, String username, Roles role) {
        if (login.length() < 3 || password.length() < 3 || username.length() < 3) {
            clientHandler.sendMsg("Логин 3+ символа, пароль 3+ символа, имя пользователя 3+ символа");
            return false;
        }
        if (isLoginAlreadyExists(login)) {
            clientHandler.sendMsg("Указанный логин уже занят");
            return false;
        }
        if (isUsernameAlreadyExists(username)) {
            clientHandler.sendMsg("Указанное имя пользователя уже занято");
            return false;
        }
        users.add(new User(login, password, username, role));
        clientHandler.setUsername(username);
        clientHandler.setRole(role);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/regok " + username);
        return true;
    }
}
