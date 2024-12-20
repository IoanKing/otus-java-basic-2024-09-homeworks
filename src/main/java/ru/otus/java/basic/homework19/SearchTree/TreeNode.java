package ru.otus.java.basic.homework19.SearchTree;

import java.util.List;

public class TreeNode<T> implements SearchTree<T> {
    private Node rootNode;

    final int MAX_ARRAY_SIZE = 100;

    public TreeNode() {
        this.rootNode = null;
    }

    public void print() {
        print("", rootNode, false);
    }

    public void print(String prefix, Node node, boolean isLeft) {
        if (node != null) {
            if (rootNode == node) {
                System.out.println (prefix + "*-- " + node.getValue());
            } else {
                System.out.println (prefix + (isLeft ? "L-- " : "R-- ") + node.getValue());
            }
            print(prefix + (isLeft ? "|   " : "    "), node.getLeft(), true);
            print(prefix + (isLeft ? "|   " : "    "), node.getRight(), false);
        }
    }

    @Override
    public T find(T element) {
        return (T) searchElement(rootNode, (Node) element);
    }

    private Node searchElement(Node currentNode, Node element) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.getValue() == element.getValue()) {
            return currentNode;
        }
        if (currentNode.getValue() < element.getValue()) {
            return searchElement(currentNode.getRight(), element);
        }
        if (currentNode.getValue() > element.getValue()) {
            return searchElement(currentNode.getLeft(), element);
        }
        return null;
    }


    @Override
    public List<T> getSortedList() {
        int[] array = new int[MAX_ARRAY_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        rootNode = makeTree(array, 0, array.length-1);

        return List.of((T)rootNode);
    }

    private Node makeTree (int[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        int middle = (start + end) / 2;

        Node root = new Node(array[middle]);
        root.setLeft(makeTree(array, start, middle - 1));
        root.setRight(makeTree(array, middle + 1, end));

        return root;
    }
}