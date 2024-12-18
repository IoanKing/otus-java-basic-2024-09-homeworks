package ru.otus.java.basic.homework19;

import ru.otus.java.basic.homework19.PersonDataBase.Person;
import ru.otus.java.basic.homework19.PersonDataBase.PersonDataBase;
import ru.otus.java.basic.homework19.PersonDataBase.Position;
import ru.otus.java.basic.homework19.SearchTree.Node;
import ru.otus.java.basic.homework19.SearchTree.TreeNode;
import ru.otus.java.basic.homework19.Utils.Measure;
import ru.otus.java.basic.homework19.Utils.SortArray;
import static ru.otus.java.basic.homework19.Utils.RandomInt.getRandomInt;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("===== Домашнее задание. Лекция №19 ======");
        System.out.println("=========================================");

        final int MAX_SIZE = 100_000;
        final String NEW_PERSON_NAME = "Иванов Иван Иванович";
        final int SEARCH_INDEX_1 = 5_000;
        final int SEARCH_INDEX_2 = 2_500;
        final int SEARCH_INDEX_3 = 6_500;
        final int MAX_ARRAY_SIZE = 10_000;
        final int MIN_ARRAY_VALUE = -1_000;
        final int MAX_ARRAY_VALUE = 1_000;
        final int SEARCH_ELEMENT = 63;
        int[] array = new int[MAX_ARRAY_SIZE];

        System.out.println("\n=============ЗАДАНИЯ ПРО PERSONAL DATA BASE===========");

        PersonDataBase dataBase= new PersonDataBase();
        Person searchedPerson;
        boolean isManager;
        boolean isEmployer;

        System.out.println("\n----------генерация массива значений----------");
        Measure.stamp();
        for (int i = 0; i < MAX_SIZE; i++) {
            dataBase.add(new Person("Employer " + i, Position.getRandom()));
        }
        Measure.print();
        System.out.println("Всего " + dataBase.getSize() + " записей.");

        System.out.println("\n----------добавление нового сотрудника----------");
        System.out.println(NEW_PERSON_NAME);
        Measure.stamp();
        dataBase.add(new Person(NEW_PERSON_NAME, Position.getRandom()));
        Measure.print();
        System.out.println("Всего " + dataBase.getSize() + " записей.");

        System.out.println("\n----------ПОИСК СОТРУДНИКА ПО ID----------");
        System.out.println("id: " + SEARCH_INDEX_1);
        Measure.stamp();
        searchedPerson = dataBase.findById((long)SEARCH_INDEX_1);
        Measure.print();
        System.out.println(searchedPerson.toString());

        System.out.println("\n----------ПРОВЕРКА НА РУКОВОДИТЕЛЯ----------");
        searchedPerson = dataBase.findById((long)SEARCH_INDEX_2);
        System.out.println("isManager: " + searchedPerson.toString());
        Measure.stamp();
        isManager = dataBase.isManager(searchedPerson);
        Measure.print();
        System.out.println(isManager ? "ДА" : "НЕТ");

        System.out.println("\n----------ПРОВЕРКА НА СОТРУДНИКА----------");
        searchedPerson = dataBase.findById((long)SEARCH_INDEX_3);
        System.out.println("isEmployee: " + searchedPerson.toString());
        Measure.stamp();
        isEmployer = dataBase.isEmployee((long)SEARCH_INDEX_3);
        Measure.print();
        System.out.println(isEmployer ? "ДА" : "НЕТ");

        System.out.println("\n=============ЗАДАНИЯ ПРО СОРТИРОВКУ===========");

        System.out.println("\n----------Генерация случайного массива----------");
        Measure.stamp();
        for (int i = 0; i < array.length; i++) {
            array[i] = getRandomInt(MIN_ARRAY_VALUE, MAX_ARRAY_VALUE);
        }
        Measure.print();
        System.out.println(Arrays.toString(array));

        System.out.println("\n----------Сортировка (пузырьком)----------");
        Measure.stamp();
        SortArray.bubbleSort(array);
        Measure.print();
        System.out.println(Arrays.toString(array));

        System.out.println("\n----------Генерация случайного массива----------");
        Measure.stamp();
        for (int i = 0; i < array.length; i++) {
            array[i] = getRandomInt(MIN_ARRAY_VALUE, MAX_ARRAY_VALUE);
        }
        Measure.print();
        System.out.println(Arrays.toString(array));

        System.out.println("\n----------Сортировка (быстрая сортировка)----------");
        Measure.stamp();
        SortArray.quickSort(array, 0, array.length-1);
        Measure.print();
        System.out.println(Arrays.toString(array));

        System.out.println("\n=============ЗАДАНИЯ С ДВОИЧНЫМ ДЕРЕВОМ ПОИСКА===========");

        TreeNode<Node> searchTree = new TreeNode<>();

        System.out.println("\n----------Построение дерева ----------");
        Measure.stamp();
        searchTree.getSortedList();
        Measure.print();

        System.out.println("\n----------Визуализация дерева----------");
        Measure.stamp();
        searchTree.print();
        Measure.print();

        System.out.println("\n----------Поиск элемента (" + SEARCH_ELEMENT + ")----------");
        Node searchedElement = new Node(SEARCH_ELEMENT);
        Measure.stamp();
        Node searchResult = searchTree.find(searchedElement);
        Measure.print();
        System.out.println("searchResult: " + searchResult);
    }
}
