package LinkedList;

import javax.swing.plaf.IconUIResource;

public class SinglyLinkedList {
    class node {
        private int data;
        private node next;

        public node(int data, node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public node getNext() {
            return next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setNext(node next) {
            this.next = next;
        }
    }

    private node head;
    private node tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public node getHead() {
        return head;
    }

    public node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void prepend(int data) {
        head = new node(data, head);

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    void append(int data) {
        if (head == null) {
            prepend(data);
        }
        else {
            tail.setNext(new node(data, null));
            tail = tail.getNext();
        }

        size++;
    }

    void insert(node n, int data) throws IllegalArgumentException {
        if (n == null) {
            throw new IllegalArgumentException("Invalid address provided (NULL).");
        }
        else {
            n.setNext(new node(data, n.getNext()));

            size++;
        }
    }

    void removeTail() {
        node current_node = head;

        if (current_node == null) {
            return;
        }
        if (current_node.getNext() == null) {
            head = tail = null;
        }

        while (current_node.getNext().getNext() != null) {
            current_node = current_node.getNext();
        }

        current_node.setNext(null);

        tail = current_node;
    }

    void remove_node(node n) throws IllegalArgumentException {
        if (n == null) {
            throw new IllegalArgumentException("Invalid address provided (NULL).");
        }
        else {
            if (n != tail) {
                if (n.getNext() != null) {
                    n.setData(n.getNext().getData());
                    n.setNext(n.getNext().getNext());
                }
                else {

                }
            }
            else {
                removeTail();
            }

            size--;
        }
    }

    void print_list() {
        node current_node = head;

        while (current_node != null) {
            System.out.println(current_node.getData());

            current_node = current_node.next;
        }
    }
}
