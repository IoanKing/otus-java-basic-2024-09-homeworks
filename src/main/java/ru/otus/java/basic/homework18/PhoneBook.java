package ru.otus.java.basic.homework18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    final private Map<String, String> map = new HashMap<>();

    public PhoneBook(String[] phones, String[] name) {
        int maxSize = Math.min(phones.length, name.length);
        for (int i = 0; i < maxSize; i++) {
            map.put(phones[i], name[i]);
        }
    }

    public void add(String name, String phoneNumber) {
        if (this.containsPhoneNumber(phoneNumber)) {
            System.out.println("В телефонной книге уже содержится номер: " + phoneNumber);
            return;
        }
        map.put(phoneNumber, name);
    }

    public ArrayList<String> find(String name) {
        ArrayList<String> phoneNumbers = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(name)) {
                phoneNumbers.add(entry.getKey());
            }
        }
        return phoneNumbers;
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        return map.containsKey(phoneNumber);
    }

    public void info() {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " | " + value);
        }
        System.out.println();
    }


}
