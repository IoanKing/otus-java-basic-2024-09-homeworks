package ru.otus.java.basic.homework29;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainApp {
    final static String DEFAULT_PATH = ".";
    final static String DEFAULT_FILE_TYPE = ".txt";

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("===== Домашнее задание. Лекция №29 ======");
        System.out.println("=========================================");
        Scanner scanner = new Scanner(System.in);
        String fileName, pattern;
        List<String> fileList;
        int count;

        System.out.println("Список файлов в директории: " + DEFAULT_PATH);
        fileList = getFileList(Path.of(DEFAULT_PATH));
        fileList.stream().forEach(System.out::println);

        System.out.println("Выберите файл для работы: ");
        fileName = scanner.nextLine();

        System.out.println("Выберите паттерн для проверки: ");
        pattern = scanner.nextLine();

        System.out.println("-------расчёт--------");
        count = getCountMatches(fileName, pattern);

        System.out.println("Найдено совпадений: " + count);

        System.out.println("-------содержимое файла--------");
        printFile(fileName);
    }

    /**
     * Метод подсчитывает сколько раз в текстовом файле (с кодировкой UTF-8) встречается указанная последовательность символов с учетом регистра
     *
     * @param filename проверяемый файл
     * @param matchText последовательность символов.
     */
    private static int getCountMatches(String filename, String matchText) {
        int count = 0;
        File file = new File(DEFAULT_PATH);
        if (!file.exists()) {
            System.out.println("Файла не существует.");
            return 0;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8))) {
            String line;
            Pattern pattern = Pattern.compile(matchText);
            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    count++;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    /**
     * Метод получает список файлов из корневой директории проекта с расширением.
     *
     * @return список названий файлов
     */
    private static List<String> getFileList(Path path) {
        File file = new File(DEFAULT_PATH);
        if (!file.exists()) {
            System.out.println("Директория не существует.");
            return null;
        }
        List<String> fileList;
        fileList = Arrays.stream(Objects.requireNonNull(file.list(new FileTypeFilter(DEFAULT_FILE_TYPE)))).toList();
        assert fileList != null;
        return fileList;
    }

    /**
     * Метод выводит в консоль содержимое текстового файла из корневой директории проекта.
     *
     * @param fileName название файла.
     */
    private static void printFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Файл не существует.");
            return;
        }
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
