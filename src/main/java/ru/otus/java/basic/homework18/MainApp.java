package ru.otus.java.basic.homework18;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("===== Домашнее задание. Лекция №18 ======");
        System.out.println("=========================================");
        String[] names = {
                "Иванов Иван Иванович",
                "Петров Пётр Петрович",
                "Сидоров Артём Николаевич",
                "Виктор Павел Сергеевич",
                "Иванова Алёна Сергеевна",
                "Сидорова Светлана Алексеевна",
                "Комсомолов Дмитрий Степанович",
                "Полежайкина Виктория Сергеевна",
                "Сорокин Дмитрий Николаевич",
                "Воробьева Анна Никифоровна"
        };
        String[] phones = {
                "+7(921)111-11-11",
                "+7(921)222-22-22",
                "+7(921)333-33-33",
                "+7(921)444-44-44",
                "+7(921)555-55-55",
                "+7(921)666-66-66",
                "+7(921)777-77-77",
                "+7(921)888-88-88",
                "+7(921)999-99-99",
                "+7(926)111-11-11"
        };
        String newName = "Иванов Иван Иванович";
        String newPhone1 = "+7(945)123-45-67";
        String[] checkedNumbers = {
                "+7(945)123-45-67",
                "+7(945)987-65-43",
                "+7(921)555-55-55"
        };
        String[] checkedNames = {
                "Иванов Иван Иванович",
                "Сидорова Светлана Алексеевна",
                "Сильвестер Сталоне"
        };

        PhoneBook phoneBook = new PhoneBook(phones, names);

        System.out.println("\n---Телефонная книга---");
        phoneBook.info();

        System.out.println("\n---Добавление нового номера---");
        System.out.println("Добавляем в книгу: " + newPhone1 + " | " + newName);
        phoneBook.add(newName, newPhone1);
        System.out.println("Добавляем в книгу: " + newPhone1 + " | " + newName + " (проверка на дубликат телефона)");
        phoneBook.add(newName, newPhone1);

        System.out.println("\n---Проверяем что номер есть в книге---");
        for (String number : checkedNumbers) {
            System.out.println("В телефонной книге содержится номер: " + number + " ?");
            System.out.println( phoneBook.containsPhoneNumber(number) ? "ДА" : "НЕТ");
        }

        System.out.println("\n---Проверяем какие номера есть у сотрудника в книге---");
        for (String name : checkedNames) {
            System.out.println("Какие номера есть в книге у сотрудника \"" + name + "\" ?");
            System.out.println(phoneBook.find(name));
        }
    }
}
