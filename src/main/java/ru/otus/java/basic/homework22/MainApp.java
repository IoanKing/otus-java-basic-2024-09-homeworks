package ru.otus.java.basic.homework22;

import ru.otus.java.basic.homework22.Utils.Measure;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=========================================");
        System.out.println("===== Домашнее задание. Лекция №21 ======");
        System.out.println("=========================================");

        double[] array;

        System.out.println("---Генерация массива (цикл for)---");
        Measure.stamp();
        array = createArray();
        Measure.print();

        System.out.println("---Генерация массива (в потоке)---");
        System.out.println();
        Measure.stamp();
        array = createArrayThread();
        Measure.print();
    }

    public static double[]  createArray() {
        final int ARRAY_SIZE = 100_000_000;
        double[] array = new double[ARRAY_SIZE];

        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        return array;
    }

    public static double[]  createArrayThread() throws InterruptedException {
        final int ARRAY_SIZE = 100_000_000;
        double[] array = new double[ARRAY_SIZE];

        int arrayPartSize = ARRAY_SIZE / 4;

        MyThread thread0 = new MyThread(array, 0, arrayPartSize-1);
        MyThread thread1 = new MyThread(array, arrayPartSize, arrayPartSize*2-1);
        MyThread thread2 = new MyThread(array, arrayPartSize*2, arrayPartSize*3-1);
        MyThread thread3 = new MyThread(array, arrayPartSize*3, arrayPartSize*4);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();

        thread0.join();
        thread1.join();
        thread2.join();
        thread3.join();

        return array;
    }
}
