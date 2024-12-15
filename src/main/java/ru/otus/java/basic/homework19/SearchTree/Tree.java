package ru.otus.java.basic.homework19.SearchTree;

import java.util.ArrayList;
import java.util.List;

import static ru.otus.java.basic.homework19.MainApp.getRandomInt;

public class Tree implements SearchTree {
    private int key;
    private Tree root, left, right;

    public void add(int key) {
        root = addNode(root, key);
    }

    public Tree getRoot() {
        return root;
    }

    private Tree addNode(Tree root, int key) {
        if (root == null) {
            root = new Tree(key);
            return root;
        }

        if (key < root.key)
            root.left = addNode(root.left, key);
        else if (key > root.key)
            root.right = addNode(root.right, key);

        return root;
    }

    private Tree searchNode(Tree root, int key) {
        if (root == null)
            return null;

        if (root.key == key)
            return root;

        if (key < root.key)
            return searchNode(root.left, key);
        else
            return searchNode(root.left, key);
    }

    @Override
    public Object find(Object element) {
        return searchNode(root, (int) element);
    }

    public Tree getSortedList() {
        final int MAX_ARRAY_SIZE = 1_000;
        final int MIN_VALUE = -1000;
        final int MAX_VALUE = 1000;

        int value = getRandomInt(MIN_VALUE, MAX_VALUE);
        int[] array = new int[MAX_ARRAY_SIZE];

        for (int i = 0; i < array.length; i++) {
            array[i] = value++;
        }

        double cantralIndex = array.length / 2;
        if (cantralIndex % 2 != 0) {
            cantralIndex = Math.round(cantralIndex) + 1;
        }

        this.add(array[(int) cantralIndex]);

        for (int i = 0; i < array.length; i++) {
            if (i != (int) cantralIndex) {
                this.add(array[i]);
            }
        }

        return this.root;
    }

    @Override
    public String toString() {
        return "Tree{key: " + key + " }";
    }

    public Tree(int key) {
        this.root = this;
        this.key = key;
    }
}
