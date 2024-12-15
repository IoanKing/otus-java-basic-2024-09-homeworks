package ru.otus.java.basic.homework20;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("===== Домашнее задание. Лекция №20 ======");
        System.out.println("=========================================");

        final String DEFAULT_PATH = ".";
        final String DEFAULT_FILE_TYPE = ".txt";
        File file = new File(DEFAULT_PATH);
        String[] fileList;

        Scanner scanner = new Scanner(System.in);
        int command = 0;

        if (!file.exists()) {
            System.out.println("Директория не существует.");
            return;
        }

        System.out.println("Список файлов в корневой директории c расширением \"" + DEFAULT_FILE_TYPE + "\": ");
        fileList = file.list(new FileTypeFilter(DEFAULT_FILE_TYPE));
        if (fileList.length == 0) {
            System.out.println("В директории нет файлов с расширением \"" + DEFAULT_FILE_TYPE + "\"");
            return;
        }
        for (int i = 0; i < fileList.length; i++) {
            System.out.println( (i+1) + ") " + fileList[i]);
        }

        do {
            System.out.println("Выберите файл для работы: ");
            command = scanner.nextInt();
            if (command <= fileList.length && command > 0) {
                printFile(fileList[command-1]);
                inputInFile(fileList[command-1]);
                printFile(fileList[command-1]);
                break;
            }
        } while (true);
    }

    private static void inputInFile(String fileName) {
        Scanner scanner = new Scanner(System.in);
        String newLine;
        System.out.println("Введите строчку текста для записи в файл");
        newLine = scanner.nextLine();

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName, true))) {
            byte[] buffer = newLine.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFile(String fileName) {
        try (   FileInputStream fis = new FileInputStream(fileName);
                BufferedInputStream bis = new BufferedInputStream(fis);
                InputStreamReader in = new InputStreamReader(bis) ) {
            int n = in.read();
            System.out.println("Содержимое файла \"" + fileName + "\"");
            System.out.println("-------------------");
            while (n != -1) {
                System.out.print((char)n);
                n = in.read();
            }
            System.out.println("\n-------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
