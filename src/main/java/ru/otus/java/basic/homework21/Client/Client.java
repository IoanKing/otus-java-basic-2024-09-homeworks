package ru.otus.java.basic.homework21.Client;

import ru.otus.java.basic.homework21.Util.ExampleClient;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("===== Домашнее задание. Лекция №21 ======");
        System.out.println("=====           КЛИЕНТ             ======");
        System.out.println("=========================================");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try (Socket socket = new Socket("localhost", 8080)) {
                ExampleClient client = new ExampleClient(socket.getInputStream(), socket.getOutputStream());
                System.out.println("Выберите операцию:");
                System.out.println("* Арифметическая операция: <Целое_число> <операция> <Целое_число>");
                System.out.println("* Для выхода ввести: exit");
                String userMessage = scanner.nextLine();
                if (userMessage.equals("exit")) {
                    client.send(userMessage);
                    break;
                }
                client.send(userMessage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
