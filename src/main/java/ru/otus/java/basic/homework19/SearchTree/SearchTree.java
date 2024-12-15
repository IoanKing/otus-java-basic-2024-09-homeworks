package ru.otus.java.basic.homework19.SearchTree;

import java.util.List;

public interface SearchTree<T> {

    /**
     * @param element to find
     * @return element if exists, otherwise - null
     */
    T find(T element);

//    List<T> getSortedList();
}
