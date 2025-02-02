package ru.otus.java.basic.homework24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;

    private String username;
    private static int userCount = 0;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        userCount++;
        username = "user" + userCount;

        new Thread(() -> {
            try {
                System.out.println("Клиент подключился " + socket.getPort());

                while (true) {
                    String message = in.readUTF();
                    String targetUsername = "";
                    String targetMessage = "";
                    if (message.startsWith("/")) {
                        if (message.equalsIgnoreCase("/exit")) {
                            sendMsg("/exitok");
                            break;
                        }
                        if (message.startsWith("/name")) {
                            server.clientMessage("name = " + username, username);
                        }
                        server.clientMessage(username + " : " + targetMessage, targetUsername);
                        if (message.startsWith("/w")) {
                            if (message.contains(" ")) {
                                targetUsername = message.substring(3, message.indexOf(" ", 3));
                                targetMessage = message.substring(message.indexOf(" ", 3) + 1);
                            } else {
                                sendMsg("Ошибка: Неверный формат команды.");
                                continue;
                            }
                            server.clientMessage(username + " : " + targetMessage, targetUsername);
                        }
                    } else {
                        server.broadcastMessage(username + " : " + message);
                    }
                }
            } catch (IOException e) {
                System.err.println("Ошибка при подключении клиента: " + e.getMessage());
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();
    }

    public void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            System.err.println("Ошибка при отправки сообщения клиенту: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void disconnect() {
        server.unsubscribe(this);
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при отключении клиента от сервера: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при отключении клиента от сервера: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при отключении клиента от сервера: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}
