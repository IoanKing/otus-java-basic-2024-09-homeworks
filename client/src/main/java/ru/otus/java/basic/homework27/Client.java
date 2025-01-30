package ru.otus.java.basic.homework27;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Client {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Scanner scanner;

    public Client() throws IOException {
        scanner = new Scanner(System.in);
        socket = new Socket("localhost", 8189);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());

        new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equalsIgnoreCase("/exitok")) {
                            break;
                        }
                        if (message.equalsIgnoreCase("/kickoff")) {
                            out.writeUTF("/exit");
                        }
                        if (message.startsWith("/authok ")) {
                            System.out.println("Удалось успешно войти в чат с именем пользователя "
                                    + message.split(" ")[1]);
                        }
                        if (message.startsWith("/regok ")) {
                            System.out.println("Удалось успешно зарегистрироваться с именем пользователя "
                                    + message.split(" ")[1]);
                        }
                    } else {
                        System.out.println(message);
                    }
                }
            } catch (IOException e) {
                System.err.println("Ошибка при установлении соединения: " + e.getMessage());
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();

        while (true) {
            String message = scanner.nextLine();
            if (socket.isClosed()) {
                System.out.println("Вы были отключены от чата администратором.");
                break;
            }
            out.writeUTF(message);
            if (message.equalsIgnoreCase("/exit")) {
                break;
            }
        }
    }

    public void disconnect() {
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при отключении соединения: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при отключении соединения: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            System.err.println("Ошибка при отключении соединения: " + e.getMessage());
            e.printStackTrace();
        }
    }
}