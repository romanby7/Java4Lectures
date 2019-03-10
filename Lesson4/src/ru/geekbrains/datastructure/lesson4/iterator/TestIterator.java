package ru.geekbrains.datastructure.lesson4.iterator;

import ru.geekbrains.datastructure.lesson4.linkedlist.Entry;
import ru.geekbrains.datastructure.lesson4.linkedlist.LinkedList;
import ru.geekbrains.datastructure.lesson4.linkedlist.SimpleLinkedListImpl;

import java.util.ArrayList;
import java.util.Iterator;

public class TestIterator {

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3};
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

        System.out.println("---------");

        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);

        for (Integer element : linkedList) {
            System.out.println(element);
        }


        System.out.println("---------");
        System.out.println("JDK:");

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }

        Iterator<Integer> iterator = arrayList.iterator();
        while ( iterator.hasNext() ) {
            Integer next = iterator.next();
            System.out.println(next);
        }


        java.util.LinkedList<Integer> linkedListJdk = new java.util.LinkedList<>();
        for (Integer integer : linkedListJdk) {

        }


//        for (Element element : collection) {
//            doAction(element);
//        }

    }
}
