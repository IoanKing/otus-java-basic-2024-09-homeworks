package ru.otus.java.basic.homework19.PersonDataBase;

import java.util.HashMap;
import java.util.HashSet;

public class PersonDataBase {
    private HashMap<Long, Person> dataBase = new HashMap<>();
    private HashSet<Position> positionList = new HashSet<>();

    public Person findById(Long id) {
        return dataBase.get(id);
    }

    public void add(Person person)  {
        dataBase.put(person.getId(), person);
    }

    public int getSize() {
        return dataBase.size();
    }

    public boolean isManager(Person person) {
        return positionList.contains(person.getPosition());
    }

    public boolean isEmployee(Long id) {
        return !isManager(dataBase.get(id));
    }

    public PersonDataBase() {
        positionList.add(Position.MANAGER);
        positionList.add(Position.BRANCH_DIRECTOR);
        positionList.add(Position.DIRECTOR);
        positionList.add(Position.SENIOR_MANAGER);
    }
}