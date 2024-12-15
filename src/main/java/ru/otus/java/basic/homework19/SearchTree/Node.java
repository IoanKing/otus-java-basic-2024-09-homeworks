package ru.otus.java.basic.homework19.SearchTree;

class Node {
    private int key;
    private Node left, right;

    public int getKey() {
        return key;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int item) {
        key = item;
        left = right = null;
    }
}
