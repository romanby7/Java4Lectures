package ru.geekbrains.datastructure.lesson4.linkedlist;

import ru.geekbrains.datastructure.lesson4.iterator.ListIterator;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    protected int currentSize;


    @Override
    public void insert(E value) {
        Entry<E> newElement = new Entry<>(value);//002
        newElement.setNext(firstElement);//001 next -> 001
        firstElement = newElement;//002
        currentSize++;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }


        Entry<E> removedElement = firstElement;
        firstElement = firstElement.getNext();
        currentSize--;
        return removedElement.getValue();
    }

    @Override
    public boolean remove(E value) {
        Entry<E> current = firstElement;
        Entry<E> previous = null;

        while ( current != null ) {
            if ( current.getValue().equals(value) ) {
                break;
            }
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.getNext();
        }
        else {
            previous.setNext(current.getNext());
        }

        currentSize--;

        return true;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean find(E value) {
        Entry<E> current = firstElement;
        while ( current != null ) {
            if ( current.getValue().equals(value) ) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    @Override
    public void display() {
        System.out.println("------");
        System.out.println("display " + this.getClass().getSimpleName());

        Entry<E> current = firstElement;
        while ( current != null ) {
            System.out.println(current);
            current = current.getNext();
        }

        System.out.println("------");
    }

    @Override
    public E getFirstElement() {
        return firstElement.getValue();
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>(this);
    }



    private static class LinkedListIterator<E> implements ListIterator<E> {

        private SimpleLinkedListImpl list;

        private Entry<E> current;
        private Entry<E> previous;

        public LinkedListIterator(SimpleLinkedListImpl list) {
            this.list = list;
            reset();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E nextValue = current.getValue();
            previous = current;
            current = current.getNext();
            return nextValue;
        }

        @Override
        public void remove() {
            if (previous == null){
                list.firstElement = current.getNext();
                reset();
            } else {
                previous.setNext(current.getNext());
                if ( !hasNext() ) {
                    reset();
                } else {
                    current = current.getNext();
                }
            }
        }

        @Override
        public void reset() {
            current = list.firstElement;
            previous = null;
        }

        @Override
        public void insertBefore(E value) {
            Entry newItem = new Entry(value);
            if(previous == null) {
                newItem.setNext(list.firstElement);
                list.firstElement = newItem;
                reset();
            }
            else {
                newItem.setNext(previous.getNext());
                previous.setNext(newItem);
                current = newItem;
            }

        }

        @Override
        public void insertAfter(E value) {
            Entry newItem = new Entry(value);
            if (list.isEmpty()){
                list.firstElement = newItem;
                current = newItem;
            } else {
                newItem.setNext(current.getNext());
                current.setNext(newItem);
                next();
            }
        }

    }
}
