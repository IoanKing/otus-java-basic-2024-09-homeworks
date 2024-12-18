package ru.otus.java.basic.homework19.PersonDataBase;

import java.util.Objects;

public class Person {
    private String name;
    private Position position;
    private static Long id = 0L;

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Long getId() {
        return id;
    }

    public Person(String name, Position position) {
        this.name = name;
        this.position = position;
        id++;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Person{" + name + ", " + position + "}";
    }
}