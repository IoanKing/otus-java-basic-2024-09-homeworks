package ru.otus.java.basic.homework27.JDBC;

import ru.otus.java.basic.homework27.ClientHandler;
import ru.otus.java.basic.homework27.DBObjects.Role;
import ru.otus.java.basic.homework27.DBObjects.User;
import ru.otus.java.basic.homework27.Server;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserServiceJDBCImpl implements UserServiceJDBC {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/otus-db";
    private static final String USERS_QUERY = "select * from users";
    private static final String ROLES_QUERY = "select * from roles";
    private static final String USER_ROLE_QUERY = """
            select r.id, r."name" from roles r
            	join users_to_role ur on r.id = ur.roles_id
            	where users_id = ?
            	ORDER BY r.id DESC
            """;

    private static final String IS_ADMIN_QUERY = """
            select count(1) from roles r
            	join users_to_role ur on r.id = ur.role_id
            	where user_id = ? and r."name" = 'admin'
            """;

    private static final String IS_USER_EXISTS = """
            select id from users where email = ?
            """;

    private static final String AUTHENTICATE = """
            select u.id from users u where u.username = ? and u.password = ?;
            """;

    private static final String ADD_USER = """
            insert into users (email, password, username) VALUES (?, ?, ?);
            """;

    private static final String SET_ROLE = """
            insert into users (email, password) VALUES (?, ?);
            """;

    private static final String GET_USER = """
            select username from users where username = ?;
            """;

    private final Connection connection;
    private Server server;

    public UserServiceJDBCImpl(Server server) throws SQLException {
        this.server = server;
        this.connection = DriverManager.getConnection(DATABASE_URL, "admin", "password");
        System.out.println("---Подключение у БД---");
    }

    @Override
    public boolean isAdmin(int userId) {
        int flag = 0;
        PreparedStatement psObj = null;
        try (PreparedStatement ps = connection.prepareStatement(IS_ADMIN_QUERY)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    flag = rs.getInt(1);
                }
            }
            psObj = ps;
        } catch (SQLException e) {
            System.err.println("Ошибка при проверки на администратора: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (psObj != null) {
                    psObj.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка отключении от БД (проверка администратора): " + e.getMessage());
                e.printStackTrace();
            }
        }
        return flag == 1;
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        PreparedStatement psObj = null;
        int userId = 0;
        String role;
        System.out.println("Аутентификация пользователя = " + login);
        if (server.isUsernameBusy(login)) {
            clientHandler.sendMsg("Указанная учетная запись уже занята");
            return false;
        }
        try (PreparedStatement ps = connection.prepareStatement(AUTHENTICATE)) {
            ps.setString(1, login);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    userId = rs.getInt(1);
                    System.out.println("userId = " + userId);
                }
            }
            if (userId != 0) {
                System.out.println("userId = " + userId);
                role = getRole(userId);
                System.out.println("role = " + role);
                clientHandler.sendMsg("/authok " + login);
                clientHandler.setUsername(login);
                clientHandler.setRole(role);
                server.subscribe(clientHandler);
            }
            psObj = ps;
        } catch (SQLException e) {
            System.err.println("Ошибка при аутентификации: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (psObj != null) {
                    psObj.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при отключении от БД (аутентификация): " + e.getMessage());
                e.printStackTrace();
            }
        }
        return (userId != 0) ? true : false;
    }

    @Override
    public boolean registration(ClientHandler clientHandler, String email, String password, String userName, String role) {
        boolean flag = false;
        int userId = 0;
        if (userIsExists(email) != 0) {
            clientHandler.sendMsg("Указанная учетная запись уже занята");
            return false;
        }
        try {
            addUser(email, password, userName);
            clientHandler.setUsername(userName);
            userId = getUser(email);
            if (userId != 0) {
                setRole(userId);
            }
            flag = true;
            server.subscribe(clientHandler);
        } catch (Exception e) {
            System.err.println("Ошибка при регистрации: " + e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    private void addUser(String email, String password, String userName) {
        PreparedStatement psObj = null;
        try {
            psObj = connection.prepareStatement(ADD_USER);
            psObj.setString(1, email);
            psObj.setString(2, password);
            psObj.setString(3, userName);
            psObj.executeQuery();
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении пользователя: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (psObj != null) {
                    psObj.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии подключения (добавление пользователя): " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private int getUser(String login) {
        int userId = 0;
        PreparedStatement psObj = null;
        try {
            psObj = connection.prepareStatement(GET_USER);
            psObj.setString(1, login);
            try (ResultSet rs = psObj.executeQuery()) {
                while (rs.next()) {
                    userId = rs.getInt(1);
                    break;
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при поиске пользователя в БД: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (psObj != null) {
                    psObj.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка при отключении от БД (поиск пользователя): " + e.getMessage());
                e.printStackTrace();
            }
        }
        return userId;
    }

    private void setRole(int userId) {
        PreparedStatement psObj = null;
        try {
            psObj = connection.prepareStatement(SET_ROLE);
            psObj.setInt(1, userId);
            psObj.executeQuery();
        } catch (SQLException e) {
            System.err.println("Ошибка при установки роли пользователю: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (psObj != null) {
                    psObj.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка отключении от БД (роли): " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private String getRole(int userId) {
        String role = "";
        PreparedStatement psObj = null;
        try {
            psObj = connection.prepareStatement(USER_ROLE_QUERY);
            psObj.setInt(1, userId);
            try (ResultSet rs = psObj.executeQuery()) {
                while (rs.next()) {
                    role = rs.getString(2);
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении роли пользователю: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (psObj != null) {
                    psObj.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка отключении от БД (получение роли): " + e.getMessage());
                e.printStackTrace();
            }
        }
        return role;
    }

    private int userIsExists(String email) {
        int flag = 0;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(IS_USER_EXISTS);
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    flag = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при проверки существования пользователя.: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.err.println("Ошибка отключении от БД (проверка пользователя): " + e.getMessage());
                e.printStackTrace();
            }
        }
        return flag;
    }
}
