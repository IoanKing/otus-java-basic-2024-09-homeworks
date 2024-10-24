package ru.otus.java.basic.homework10;

import java.time.Year;

public class User {
    private String surname;
    private String name;
    private String patronymic;
    private int birthYear;
    private String email;

    public User() {
        boolean isMan = MockData.getRandomBoolean();
        name = MockData.getRandomName(isMan);
        surname = MockData.getRandomSurname(isMan);
        patronymic = MockData.getRandomPatronymic(isMan);
        birthYear = MockData.getRandomBirthDate();
        email = MockData.getRandomEmail();
    }

    public int getUserAge() {
        return Year.now().getValue() - this.birthYear;
    }

    public void getUserInfo() {
        System.out.print("ФИО: " + this.surname + " " + this.name + " " + this.patronymic);
        System.out.print(" | ");
        System.out.print("Год рождения: " + this.birthYear);
        System.out.print(" | ");
        System.out.println("e-mail: " + this.email);
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getEmail() {
        return email;
    }
}
