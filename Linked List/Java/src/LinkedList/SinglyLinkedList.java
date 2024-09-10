package LinkedList;

public class SinglyLinkedList {
    private class node {
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

    public boolean isEmpty() {
        return this.size == 0;
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

    public int getFirst() {
        if (this.isEmpty()) {
            System.out.println("The list is empty");

            return -1;
        }
        else {
            return head.getData();
        }
    }

    public int getLast() {
        if (this.isEmpty()) {
            System.out.println("The list is empty");

            return -1;
        }
        else {
            return tail.getData();
        }
    }

    public void prepend(int data) {
        head = new node(data, head);

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    public void append(int data) {
        if (head == null) {
            prepend(data);
        }
        else {
            tail.setNext(new node(data, null));
            tail = tail.getNext();
        }

        size++;
    }

    public void insert(node n, int data) throws IllegalArgumentException {
        if (n == null) {
            throw new IllegalArgumentException("Invalid address provided (NULL).");
        }
        else {
            n.setNext(new node(data, n.getNext()));

            size++;
        }
    }

    public void removeHead() {
        if (head != null) {
            head = head.getNext();

            if (head == null) {
                tail = null;
            }

            size--;
        }
    }

    public void removeTail() {
        node current_node = head;

        if (current_node == null) {
            return;
        }
        if (current_node.getNext() == null) {
            head = tail = null;

            size--;

            return;
        }

        while (current_node.getNext().getNext() != null) {
            current_node = current_node.getNext();
        }

        current_node.setNext(null);

        tail = current_node;

        size--;
    }

    public void remove_node(node n) {
        if (n != null) {
            if (n.getNext() != tail) {
                if (n == tail) {
                    removeTail();
                }
                else {
                    n.setData(n.getNext().getData());
                    n.setNext(n.getNext().getNext());

                    size--;
                }
            }
            else {
                node current_node = head;

                if (n == head) {
                    removeHead();

                    return;
                }

                while (current_node.getNext().getNext() != tail) {
                    current_node = current_node.getNext();
                }

                current_node.setNext(current_node.getNext().getNext());

                size--;
            }
        }
    }

    public node search(int data) {
        if (isEmpty()) {
            return null;
        }

        node current_node = head;

        while (current_node != null) {
            if (current_node.getData() == data) {
                break;
            }

            current_node = current_node.getNext();
        }

        return current_node;
    }

    public void reverse() {
        if (!isEmpty()) {
            node current_node = head, reverse_head = null;

            tail = head;

            while (current_node != null) {
                reverse_head = new node(current_node.data, reverse_head);

                current_node = current_node.getNext();
            }

            head = reverse_head;

            tail.setNext(null);
        }
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public void print_list() {
        node current_node = head;

        while (current_node != null) {
            System.out.println(current_node.getData());

            current_node = current_node.next;
        }
    }
}
