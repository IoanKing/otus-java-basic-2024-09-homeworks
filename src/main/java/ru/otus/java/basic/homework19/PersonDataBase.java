package ru.otus.java.basic.homework19;

import java.util.HashMap;
import java.util.Objects;

public class PersonDataBase {
    private HashMap<Long, Person> dataBase = new HashMap<>();

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
        switch (person.getPosition()) {
            case MANAGER:
            case DIRECTOR:
            case SENIOR_MANAGER:
            case BRANCH_DIRECTOR:
                return true;
        }
        return false;
    }

    public boolean isEmployee(Long id) {
        switch (findById(id).getPosition()) {
            case MANAGER:
            case DIRECTOR:
            case SENIOR_MANAGER:
            case BRANCH_DIRECTOR:
                return false;
        }
        return true;
    }
}
