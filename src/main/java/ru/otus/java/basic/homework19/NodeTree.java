package ru.otus.java.basic.homework19;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class NodeTree implements SearchTree {
    int value;
    List<Tree> children = new ArrayList<>();

    @Override
    public Object find(Object element) {
        return null;
    }

    @Override
    public List<String> getSortedList() {
        return List.of();
    }
}
