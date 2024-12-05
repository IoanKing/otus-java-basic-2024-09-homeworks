package ru.otus.java.basic.homework16;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("============ Домашнее задание №16 ============");
        System.out.println("==============================================");
        final int MAX_VALUE = 10;
        final int MIN_VALUE = MAX_VALUE * -1;
        final int CALC_VALUE = 5;
        final int MAX_ARRAY_SIZE = 10;
        final int MAX_AGE = 30;
        final int MAX_AVERAGE_AGE = 30;

        System.out.println("\n1) Реализуйте метод, принимающий в качестве аргументов числа min (" + MIN_VALUE + ") и max (" + MAX_VALUE + "), " +
                "\nи возвращающий ArrayList с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);");
        ArrayList<Integer> list = new ArrayList<>();
        list = createArrayByMinMax(MIN_VALUE, MAX_VALUE);
        System.out.println(list);
        list.clear();

        System.out.println("\n2) Реализуйте метод, принимающий в качестве аргумента список целых чисел, " +
                "\nсуммирующий все элементы, значение которых больше 5, и возвращающий сумму;");
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            list.add(Utils.getRandomInt(MIN_VALUE, MAX_VALUE));
        }
        System.out.println(list);
        System.out.println("Сумма: " + getSum(list));


        System.out.println("\n3) Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список," +
                "\nметод должен переписать каждую заполненную ячейку списка указанным числом (" + CALC_VALUE + ");");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            linkedList.add(Utils.getRandomInt(MIN_VALUE, MAX_VALUE));
        }
        System.out.println(linkedList);
        fillLinkedArray(CALC_VALUE, linkedList);
        System.out.println(linkedList);
        linkedList.clear();

        System.out.println("\n4) Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список," +
                " \nувеличивающий каждый элемент списка на указанное число;\n");
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            linkedList.add(Utils.getRandomInt(MIN_VALUE, MAX_VALUE));
        }
        System.out.println(linkedList);
        increasingLinkedArray(CALC_VALUE, linkedList);
        System.out.println(linkedList);

        System.out.println("\n5) Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;");
        ArrayList<Employer> employerList = new ArrayList<>();
        employerList.add(new Employer("Ivan", 18));
        employerList.add(new Employer("Boris", 20));
        employerList.add(new Employer("Vasia", 45));
        employerList.add(new Employer("Konstantine", 40));
        employerList.add(new Employer("Alexander", 25));
        employerList.add(new Employer("Richard", 35));
        for (Employer employer : employerList) {
            System.out.println(employer.toString());
        }
        ArrayList<String> employerNames = new ArrayList<>();
        employerNames = getEmployersNames(employerList);
        System.out.println(employerNames);

        System.out.println("\n6) Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст, " +
                "\nи возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу (" + MAX_AGE + ")");
        ArrayList<Employer> employersByAge = new ArrayList<>();
        employersByAge = getEmployersByAge(employerList, MAX_AGE);
        System.out.println(employersByAge);

        boolean checkAge;
        System.out.println("\n7) Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст," +
                "\nи проверяющий что средний возраст сотрудников превышает указанный аргумент (" + MAX_AVERAGE_AGE + ")");
        checkAge = checkEmplAverageAge(employerList, MAX_AVERAGE_AGE);
        if (checkAge) {
            System.out.println("Возраст превышает заданный показатель (" + MAX_AVERAGE_AGE + ")");
        } else {
            System.out.println("Возраст НЕ превышает заданный показатель (" + MAX_AVERAGE_AGE + ")");
        }

        System.out.println("\n8) Реализуйте метод, принимающий в качестве аргумента список сотрудников,"+
                "\nи возвращающий ссылку на самого молодого сотрудника.");
        Employer youngestEmployee = getYoungestEmployee(employerList);
        System.out.println(youngestEmployee);
    }

    /**
     * Метод возвращающий ссылку на самого молодого сотрудника.
     * @param employerList список сотрудников
     * @return Employer
     */
    private static Employer getYoungestEmployee(ArrayList<Employer> employerList) {
        int age = 0;
        Employer youngestEmployee = null;
        for (Employer employer : employerList) {
            if (age == 0) {
                age = employer.getAge();
            }
            if (employer.getAge() <= age) {
                youngestEmployee = employer;
            }
        }
        return youngestEmployee;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргументов числа min и max,
     *  и возвращающий ArrayList с набором последовательных значений в указанном диапазоне
     *  (min и max включительно, шаг - 1);
     * @param min минимальное значение диапазона
     * @param max максимальное значение диапазона
     * @return ArrayList
     */
    public static ArrayList<Integer> createArrayByMinMax (int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента список целых чисел,
     *  суммирующий все элементы, значение которых больше 5, и возвращающий сумму;
     * @param value массив чисел
     * @return int
     */
    public static int getSum(ArrayList<Integer> value) {
        int sum = 0;
        for (Integer i : value) {
            if (i >= 5) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список,
     *  метод должен переписать каждую заполненную ячейку списка указанным числом;
     * @param value значение для заполнения
     * @param list LinkedList массив для заполнения
     */
    public static void fillLinkedArray (int value, LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, value);
        }
    }

    /**
     * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список,
     *  увеличивающий каждый элемент списка на указанное число;
     * @param value значение для увеличения
     * @param list LinkedList массив для заполнения
     */
    public static void increasingLinkedArray (int value, LinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + value);
        }
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
     * @param employers список сотрудников
     * @return список имен сотрудников
     */
    public static ArrayList<String> getEmployersNames (ArrayList<Employer> employers) {
        ArrayList<String> names = new ArrayList<>();
        for (Employer employer : employers) {
            names.add(employer.getName());
        }
        return names;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
     * @param employers список сотрудников
     * @return список имен сотрудников
     */
    public static ArrayList<Employer> getEmployersByAge (ArrayList<Employer> employers, int age) {
        ArrayList<Employer> employersByAge = new ArrayList<>();
        for (Employer employer : employers) {
            if (employer.getAge() >= age) {
                employersByAge.add(employer);
            }
        }
        return employersByAge;
    }

    /**
     * Метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их возрастов;
     * @param employers список сотрудников
     * @return список имен сотрудников
     */
    public static boolean checkEmplAverageAge (ArrayList<Employer> employers, int age) {
        ArrayList<Integer> employersAge = new ArrayList<>();
        for (Employer employer : employers) {
            employersAge.add(employer.getAge());
        }
        int averageAge = Utils.calculateAverage(employersAge);
        System.out.println("Средний возраст: " + averageAge);
        return averageAge >= age;
    }
}
