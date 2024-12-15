package ru.otus.java.basic.homework21.Server;

import ru.otus.java.basic.homework21.Util.ClientHandler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final List<ClientHandler> clientHandlers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println("=========================================");
        System.out.println("===== Домашнее задание. Лекция №21 ======");
        System.out.println("=====           СЕРВЕР             ======");
        System.out.println("=========================================");
        ServerSocket socket = new ServerSocket(8080);
        System.out.println("SERVER APPLICATION RUN!");
        while (true) {
            Socket client = socket.accept();
            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            System.out.println("Клиент с портом :" + client.getPort() + " подключился!");
            ClientHandler clientHandler = new ClientHandler(client, inputStream, outputStream);
            clientHandlers.add(clientHandler);
            String userInput = inputStream.readUTF();
            if (userInput.equals("exit")) {
                System.out.println("Клиент с портом :" + client.getPort() + " отключился!");
                client.close();
                continue;
            }
            System.out.println(userInput);
            String result = calculator(userInput);
            outputStream.writeUTF(result);
            outputStream.flush();
            System.out.println("result = " + result);
        }
    }

    private static String calculator(String userInput) {
        String pattern = "([-+]?[0-9]+ +[-+*/]) +([-+]?[0-9]+)";
        System.out.println("Выполняем расчёт!");
        if (userInput.matches(pattern)) {
            String[] parsedInput = userInput.split(" ");
            long value1 = Long.parseLong(parsedInput[0]);
            long value2 = Long.parseLong(parsedInput[2]);
            switch (parsedInput[1]) {
                case "+":
                    return "= " + (value1 + value2);
                case "-":
                    return "= " + (value1 - value2);
                case "*":
                    return "= " + (value1 * value2);
                case "/":
                    return "= " + (value1 / value2) + " (с округлением вниз)";
                default:
                    return "не получилось рассчитать";
            }
        }
        return "Выражение не соответствует шаблону: <Целое_число> <операция> <Целое_число>";
    }
}
