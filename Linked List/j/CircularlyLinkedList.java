package LinkedList;

public class CircularlyLinkedList <Item> {
    private node tail;
    private int size;

    public CircularlyLinkedList() {
        tail = null;
        size = 0;
    }

    public node getTail() {
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
            tail = new node <Item> (it, null);
            tail.setNext(tail);
        }
        else {
            tail.setNext(new node <Item> (it, tail.getNext()));
        }

        size++;
    }

    public void addLast(Item it) {
        if (isEmpty()) {
            tail = new node <Item> (it, null);
            tail.setNext(tail);
        }
        else {
            tail.setNext(new node <Item> (it, tail.getNext()));
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
            node head = tail.getNext();
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
