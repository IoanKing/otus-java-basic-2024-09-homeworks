package ru.otus.java.basic.homework25;

import java.io.IOException;


public class ClientApplication {
    public static void main(String[] args) {
        try {
            new Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}