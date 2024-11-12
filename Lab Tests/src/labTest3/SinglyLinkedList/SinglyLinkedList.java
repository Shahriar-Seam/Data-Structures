package labTest3.SinglyLinkedList;

import labTest3.Node.Node;

import java.util.Iterator;

public class SinglyLinkedList <Item> implements Iterable <Item> {
    private Node <Item> head;
    private Node <Item> tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Node <Item> getHead() {
        return head;
    }

    public Node <Item> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public Item getFirst() {
        if (this.isEmpty()) {
            System.out.println("The list is empty");

            return null;
        }
        else {
            return (Item) head.getData();
        }
    }

    public Item getLast() {
        if (this.isEmpty()) {
            System.out.println("The list is empty");

            return null;
        }
        else {
            return (Item) tail.getData();
        }
    }

    public void addFirst(Item data) {
        head = new Node <Item> (data, head);

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    public void addLast(Item data) {
        if (head == null) {
            addFirst(data);
        }
        else {
            tail.setNext(new Node <Item> (data, null));
            tail = tail.getNext();
        }

        size++;
    }

    public void insert(Node <Item> n, Item data) throws IllegalArgumentException {
        if (n == null) {
            throw new IllegalArgumentException("Invalid address provided (NULL).");
        }
        else {
            n.setNext(new Node <Item> (data, n.getNext()));

            size++;
        }
    }

    public Item removeFirst() {
        if (head != null) {
            Item it = (Item) head.getData();

            head = head.getNext();

            if (head == null) {
                tail = null;
            }

            size--;

            return it;
        }

        return null;
    }

    public Item removeLast() {
        Node <Item> current_node = head;

        Item it = (Item) tail.getData();

        if (current_node == null) {
            return null;
        }
        if (current_node.getNext() == null) {
            head = tail = null;

            size--;

            return it;
        }

        while (current_node.getNext().getNext() != null) {
            current_node = current_node.getNext();
        }

        current_node.setNext(null);

        tail = current_node;

        size--;

        return it;
    }

    public void remove_node(Node n) {
        if (n != null) {
            if (n.getNext() != tail) {
                if (n == tail) {
                    removeLast();
                }
                else {
                    n.setData(n.getNext().getData());
                    n.setNext(n.getNext().getNext());

                    size--;
                }
            }
            else {
                Node current_node = head;

                if (n == head) {
                    removeFirst();

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

    public Node <Item> search(Item data) {
        if (isEmpty()) {
            return null;
        }

        Node current_node = head;

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
            Node current_node = head, reverse_head = null;

            tail = head;

            while (current_node != null) {
                reverse_head = new Node(current_node.getData(), reverse_head);

                current_node = current_node.getNext();
            }

            head = reverse_head;

            tail.setNext(null);
        }
    }

    public SinglyLinkedList <Item> merge(SinglyLinkedList <Item> list) {
        SinglyLinkedList <Item> newList = new SinglyLinkedList <Item> ();

        if (list.getHead().getData() instanceof Integer) {
            Node head1 = this.head, head2 = list.getHead();

            while (head1 != null && head2 != null) {
                if ((Integer) head1.getData() < (Integer) head2.getData()) {
                    newList.addLast((Item) head1.getData());

                    head1 = head1.getNext();
                } else {
                    newList.addLast((Item) head2.getData());

                    head2 = head2.getNext();
                }
            }

            if (head1 == null) {
                while (head2 != null) {
                    newList.addLast((Item) head2.getData());

                    head2 = head2.getNext();
                }
            } else {
                while (head1 != null) {
                    newList.addLast((Item) head1.getData());

                    head1 = head1.getNext();
                }
            }
        }

        return newList;
    }

    public void removeDuplicates() {
        Node temp = head;

        while (temp != null) {
            while (temp.getNext() != null && temp.getData().equals(temp.getNext().getData())) {
                temp.setNext(temp.getNext().getNext());
            }

            temp = temp.getNext();
        }
    }

    public void removeIfGreaterValueExistsLater() {
        if (head.getData() instanceof Integer) {
            Node temp = head;

            while (temp.getNext() != null) {
                Node tempAgain = temp.getNext();

                while (tempAgain != null) {
                    if ((Integer) tempAgain.getData() > (Integer) temp.getData()) {
                        break;
                    }

                    tempAgain = tempAgain.getNext();
                }

                if (tempAgain != null) {
                    remove_node(temp);
                } else {
                    temp = temp.getNext();
                }
            }
        }
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node temp = head;

        while (temp != null) {
            sb.append(temp);

            temp = temp.getNext();

            if (temp != null) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }

    private class ListIterator implements Iterator <Item> {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
//            Nothing to see here
        }

        public Item next() {
            Item item = (Item) current.getData();
            current = current.getNext();
            return item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
}
