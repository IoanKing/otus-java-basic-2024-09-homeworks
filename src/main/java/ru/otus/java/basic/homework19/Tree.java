package ru.otus.java.basic.homework19;

import java.util.ArrayList;
import java.util.List;

public class Tree implements SearchTree {
    String name;
    List<Tree> children = new ArrayList<>();

    public Tree(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    @Override
    public Object find(Object element) {
        return null;
    }

    @Override
    public List getSortedList() {
        return List.of();
    }
}
