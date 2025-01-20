package ru.otus.java.basic.homework24;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int port;
    private List<ClientHandler> clients;

    public Server(int port) {
        this.port = port;
        clients = new CopyOnWriteArrayList<>();
    }

    public void start(){
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                subscribe(new ClientHandler(socket, this));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
        broadcastMessage("Из чата вышел: "+ clientHandler.getUsername());
    }

    public void broadcastMessage(String message){
        String targetMessage = "";
        String targetUser = "";
        if (message.startsWith("/w")) {
            int nameEndIndex = message.indexOf(" ", 3);
            targetUser = message.substring(3, nameEndIndex);
            targetMessage = message.substring(nameEndIndex + 1);
        } else {
            targetMessage = message;
        }
        for (ClientHandler c : clients) {
            String userName = c.getUsername();
            if (targetUser.isEmpty() || targetUser.equals(userName)) {
                c.sendMsg(userName + " : " + targetMessage);
            }
        }
    }
}
