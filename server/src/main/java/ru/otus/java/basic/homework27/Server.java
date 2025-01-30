package ru.otus.java.basic.homework27;

import ru.otus.java.basic.homework27.JDBC.UserServiceJDBC;
import ru.otus.java.basic.homework27.JDBC.UserServiceJDBCImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int port;
    private List<ClientHandler> clients;
    private UserServiceJDBC UserServiceJDBC;

    public Server(int port) throws SQLException {
        this.port = port;
        clients = new CopyOnWriteArrayList<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);
            UserServiceJDBC userServiceJDBC = new UserServiceJDBCImpl();
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket, this);
            }

        } catch (IOException | SQLException e) {
            System.err.println("Ошибка при запуске сервера: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
        broadcastMessage("В чат зашёл: " + clientHandler.getUsername());
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        broadcastMessage("Из чата вышел: " + clientHandler.getUsername());
    }

    public void broadcastMessage(String message) {
        for (ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }

    public void clientMessage(String message, String clientName) {
        for (ClientHandler c : clients) {
            if (c.getUsername().equals(clientName)) {
                c.sendMsg(message);
            }
        }
    }

    public void kickUser(String clientName) {
        for (ClientHandler c : clients) {
            if (c.getUsername().equals(clientName)) {
                c.sendMsg("/kickoff");
                break;
            }
        }
    }

    public boolean isUsernameBusy(String username) {
        for (ClientHandler c : clients) {
            if (c.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public UserServiceJDBC UserServiceJDBC() {
        return UserServiceJDBC;
    }
}