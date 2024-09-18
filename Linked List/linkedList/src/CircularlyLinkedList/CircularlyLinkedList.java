package CircularlyLinkedList;

import Node.Node;

import java.util.Iterator;

public class CircularlyLinkedList <Item> implements Iterable <Item> {
    private Node <Item> tail;
    private int size;

    public CircularlyLinkedList() {
        tail = null;
        size = 0;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Item getFirst() {
        if (!isEmpty()) {
            return (Item) tail.getNext().getData();
        }
        else {
            return null;
        }
    }

    public Item getLast() {
        if (!isEmpty()) {
            return (Item) tail.getData();
        }
        else {
            return null;
        }
    }

    public void addFirst(Item it) {
        if (isEmpty()) {
            tail = new Node(it, null);
            tail.setNext(tail);
        }
        else {
            tail.setNext(new Node(it, tail.getNext()));
        }

        size++;
    }

    public void addLast(Item it) {
        if (isEmpty()) {
            tail = new Node(it, null);
            tail.setNext(tail);
        }
        else {
            tail.setNext(new Node(it, tail.getNext()));
            tail = tail.getNext();
        }

        size++;
    }

    public void removeFirst() {
        if (!isEmpty()) {
            if (size == 1) {
                tail = null;
            }
            else {
                tail.setNext(tail.getNext().getNext());
            }

            size--;
        }
    }

    public void showList() {
        if (!isEmpty()) {
            Node head = tail.getNext();
            for (int i = 0; i < size; i++) {
                System.out.println(head);
                head = head.getNext();
            }
        }
        else {
            System.out.println("Empty List");
        }
    }

    public void rotate() {
        if (!isEmpty()) {
            tail = tail.getNext();
        }
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = tail.getNext();
        private int tempSize = 0;

        public boolean hasNext() {
            return tempSize != size;
        }

        public void remove() {
//            Nothing to see here
        }

        public Item next() {
            Item item = (Item) current.getData();
            current = current.getNext();

            tempSize++;

            return item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
}

