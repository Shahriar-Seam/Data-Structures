package CircularlyLinkedList;

import Node.Node;

public class CircularlyLinkedList <Item> {
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

    public int getFirst() {
        if (!isEmpty()) {
            return (int) tail.getNext().getData();
        }
        else {
            return -1;
        }
    }

    public int getLast() {
        if (!isEmpty()) {
            return (int) tail.getData();
        }
        else {
            return -1;
        }
    }

    public void addFirst(int it) {
        if (isEmpty()) {
            tail = new Node(it, null);
            tail.setNext(tail);
        }
        else {
            tail.setNext(new Node(it, tail.getNext()));
        }

        size++;
    }

    public void addLast(int it) {
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
}

