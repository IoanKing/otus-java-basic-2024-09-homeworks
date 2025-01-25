package ru.otus.java.basic.homework24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

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
                        } else {
                            System.out.println(message);
                        }
                    } else {
                        System.out.println(message);
                    }
                }
            } catch (IOException e) {
                System.err.println("Ошибка при обработке ввода с клавиатуры: " + e.getMessage());
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();

        while (true) {
            String message = scanner.nextLine();
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
