package ru.geekbrains.datastructure.lesson4.linkedlist;

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
    public Entry<E> getFirst() {
        return firstElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator();
    }

    public class SimpleLinkedListIterator implements Iterator<E> {

        Entry<E> current;
        Entry<E> previous;

        SimpleLinkedListIterator() {
            this.current = firstElement;
        }

        public Entry<E> getCurrent() {
            return current;
        }

        public E getCurrentValue() {
            return current.getValue();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E value = current.getValue();
            previous = current;
            current = current.getNext();
            return value;
        }


        @Override
        public void remove() {
            if (currentSize == 0) {
                return;
            }

            if (this.current.getNext() == null && previous == null ) {
                firstElement = null;
            }
            else if (current.getNext() != null && previous == null) {
                firstElement = current.getNext();
                current = firstElement;
            }
            else if (current.getNext() != null && previous != null) {
                previous.setNext(current.getNext());
                current = previous.getNext();
            }
            else if (current.getNext() == null && previous != null) {
                previous.setNext(null);
                current = previous;
                previous = findPrevious(firstElement, current);
            }

            currentSize--;

        }

        private Entry<E> findPrevious(Entry<E> startElement, Entry<E> current) {

            while (startElement != null) {
                if (startElement.getNext() == current) {
                    break;
                }
                startElement = startElement.getNext();

            }

            return startElement;
        }

        public void reset() {
            current = firstElement;
            previous = null;
        }

    }

}
