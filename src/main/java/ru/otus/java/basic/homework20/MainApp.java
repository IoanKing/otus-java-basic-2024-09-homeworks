package ru.otus.java.basic.homework20;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainApp {
    final static String DEFAULT_PATH = ".";
    final static String DEFAULT_FILE_TYPE = ".txt";

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("===== Домашнее задание. Лекция №20 ======");
        System.out.println("=========================================");
        String[] fileList;
        String changedFile;
        fileList = getFileList();
        changedFile = actionFileSelect(fileList);
        printFile(changedFile);
        inputInFile(changedFile);
        printFile(changedFile);
    }

    /**
     * Выбор файла из директории.
     *
     * @param fileList список доступных файлов.
     * @return название файла
     */
    private static String actionFileSelect(String[] fileList) {
        Scanner scanner = new Scanner(System.in);
        int command;

        for (int i = 0; i < fileList.length; i++) {
            System.out.println((i + 1) + ") " + fileList[i]);
        }

        do {
            System.out.println("Выберите файл для работы: ");
            command = scanner.nextInt();
            if (command <= fileList.length && command > 0) {
                return fileList[command - 1];
            }
        } while (true);
    }

    /**
     * Метод получает список файлов из корневой директории проекта с расширением ".txt".
     *
     * @return список названий файлов
     */
    private static String[] getFileList() {
        File file = new File(DEFAULT_PATH);
        if (!file.exists()) {
            System.out.println("Директория не существует.");
            return null;
        }
        String[] fileList;
        System.out.println("Список файлов в корневой директории c расширением \"" + DEFAULT_FILE_TYPE + "\": ");
        fileList = file.list(new FileTypeFilter(DEFAULT_FILE_TYPE));
        assert fileList != null;
        if (fileList.length == 0) {
            System.out.println("В директории нет файлов с расширением \"" + DEFAULT_FILE_TYPE + "\"");
            return null;
        }
        return fileList;
    }

    /**
     * Метод производить запись введенной с клавиатуры строчки в файл из корневой директории проекта.
     *
     * @param fileName название файла.
     */
    private static void inputInFile(String fileName) {
        if (fileName == null) {
            return;
        }
        Scanner scanner = new Scanner(System.in);
        String newLine;
        System.out.println("Введите строчку текста для записи в файл");
        newLine = scanner.nextLine();

        try (FileOutputStream fos = new FileOutputStream(fileName, true);
             BufferedOutputStream out = new BufferedOutputStream(fos)) {
            byte[] buffer = newLine.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод выводить в консоль содержимое текстового файла из корневой директории проекта.
     *
     * @param fileName название файла.
     */
    private static void printFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             BufferedInputStream bis = new BufferedInputStream(fis);
             InputStreamReader in = new InputStreamReader(bis)) {
            int n = in.read();
            System.out.println("Содержимое файла \"" + fileName + "\"");
            System.out.println("-------------------");
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
            System.out.println("\n-------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
