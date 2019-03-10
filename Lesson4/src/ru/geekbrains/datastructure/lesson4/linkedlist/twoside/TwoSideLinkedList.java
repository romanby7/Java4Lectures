package ru.geekbrains.datastructure.lesson4.linkedlist.twoside;

import ru.geekbrains.datastructure.lesson4.linkedlist.LinkedList;

public interface TwoSideLinkedList<E> extends LinkedList<E> {

    void insertLeft(E value);
    void insertRight(E value);

    E removeLeft();
}
