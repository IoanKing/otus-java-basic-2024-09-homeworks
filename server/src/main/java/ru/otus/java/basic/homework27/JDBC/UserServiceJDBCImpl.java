package ru.otus.java.basic.homework27.JDBC;

import ru.otus.java.basic.homework27.ClientHandler;
import ru.otus.java.basic.homework27.DBObjects.Role;
import ru.otus.java.basic.homework27.DBObjects.User;
import ru.otus.java.basic.homework27.Server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceJDBCImpl implements UserServiceJDBC {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/otus-db";
    private static final String USERS_QUERY = "select * from users";
    private static final String USER_ROLE_QUERY = """
            select r.id, r."name" from roles r
            	join users_to_roles ur on r.id = ur.role_id
            	where user_id = ?
            """;

    private static final String IS_ADMIN_QUERY = """
            select count(1) from roles r
            	join users_to_roles ur on r.id = ur.role_id
            	where user_id = ? and r."name" = 'admin'
            """;

    private static final String IS_USER_EXISTS = """
            select id from users where email = ?
            """;

    private static final String AUTHENTICATE = """
            select u.id from users u where u.email = ? and u.password = ? 
            """;

    private static final String ADD_USER = """
            insert into users (email, password) VALUES (?, ?);
            """;

    private static final String SET_ROLE = """
            insert into users (email, password) VALUES (?, ?);
            """;

    private static final String GET_USER = """
            select id from users where email = ?;
            """;

    private final Connection connection;

    public UserServiceJDBCImpl() throws SQLException {
        this.connection = DriverManager.getConnection(DATABASE_URL, "admin", "password");
    }

    @Override
    public List<User> getAll() {
        List<User> allUsers = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(USERS_QUERY)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String password = resultSet.getString(2);
                    String mail = resultSet.getString(3);
                    User user = new User(id, password, mail);
                    allUsers.add(user);
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при подключении к БД: " + e.getMessage());
            e.printStackTrace();
        }
        try (PreparedStatement prStatement = connection.prepareStatement(USER_ROLE_QUERY)) {
            for (User user : allUsers) {
                prStatement.setInt(1, user.getId());
                List<Role> roleList = new ArrayList<>();
                try (ResultSet resultSet = prStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        Role role = new Role(id, name);
                        roleList.add(role);
                    }
                    user.setRoles(roleList);
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при подключении к БД: " + e.getMessage());
            e.printStackTrace();
        }
        return allUsers;
    }

    @Override
    public boolean isAdmin(int userId) {
        int flag = 0;
        try (PreparedStatement ps = connection.prepareStatement(IS_ADMIN_QUERY)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    flag = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при подключении к БД: " + e.getMessage());
            e.printStackTrace();
        }
        return flag == 1;
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String email, String password) {
        private Server server;
        if (server.isUsernameBusy(email)) {
            clientHandler.sendMsg("Указанная учетная запись уже занята");
            return false;
        }
        try (PreparedStatement ps = connection.prepareStatement(AUTHENTICATE)) {
            ps.setString(1, email);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    clientHandler.sendMsg("/authok " + email);
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при подключении к БД: " + e.getMessage());
            e.printStackTrace();
        }
        clientHandler.sendMsg("Неверный логин или пароль");
        return false;
    }

    @Override
    public boolean registration(ClientHandler clientHandler, String email, String password, int role) {
        int userId = 0;
        if (userIsExists(email) != 0) {
            clientHandler.sendMsg("Указанная учетная запись уже занята");
            return false;
        }
        try {
            PreparedStatement ps = connection.prepareStatement(ADD_USER);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.executeQuery();

            ps = connection.prepareStatement(GET_USER);
            ps.setString(1, email);
            ps.executeQuery();
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    userId = rs.getInt(1);
                }
            }

            if (userId != 0) {
                ps = connection.prepareStatement(SET_ROLE);
                ps.setInt(1, role);
                ps.executeQuery();
            }

        } catch (SQLException e) {
            System.err.println("Ошибка при подключении к БД: " + e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    private int userIsExists(String email) {
        int flag = 0;
        try (PreparedStatement ps = connection.prepareStatement(IS_USER_EXISTS)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    flag = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
