package ru.otus.java.basic.homework25;

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
    private Roles role;


    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                System.out.println("Клиент подключился на порту: " + socket.getPort());
                //цикл аутентификации
                while (true) {
                    sendMsg("Для начала работы надо пройти аутентификацию. Формат команды /auth login password \n" +
                            "или регистрацию. Формат команды /reg login password username ");
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equalsIgnoreCase("/exit")) {
                            sendMsg("/exitok");
                            break;
                        }
                        // /auth login password
                        if (message.startsWith("/auth ")) {
                            String[] element = message.split(" ");
                            if (element.length != 3){
                                sendMsg("Неверный формат команды /auth");
                                continue;
                            }
                            if (server.getAuthenticatedProvider()
                                    .authenticate(this, element[1], element[2])){

                                break;
                            }
                        }
                        // /reg login password username
                        if (message.startsWith("/reg ")) {
                            String[] element = message.split(" ");
                            if (element.length != 4){
                                sendMsg("Неверный формат команды /reg");
                                continue;
                            }
                            if (server.getAuthenticatedProvider()
                                    .registration(this, element[1], element[2], element[3], Roles.USER)){
                                break;
                            }
                        }
                    }
                }
                //цикл работы
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
                        if (message.startsWith("/kick")) {
                            if (this.role.equals(Roles.ADMIN)) {
                                String[] element = message.split(" ");
                                if (element.length != 2){
                                    sendMsg("Неверный формат команды /kick");
                                    continue;
                                }
                                sendMsg("Пользователь был отключен от чата администратором - " + element[1]);
                                server.kickUser(element[1]);
                            } else {
                                sendMsg("Вы не можете использовать данную команду.");
                            }
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
            System.err.println("Ошибка при отключении клиента: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при отключении клиента: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
