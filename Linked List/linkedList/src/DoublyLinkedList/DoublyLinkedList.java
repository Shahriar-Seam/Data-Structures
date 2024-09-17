package DoublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedList <Item> implements Iterable <Item> {
    private class dNode {
        private Item data;
        private dNode previous;
        private dNode next;

        public dNode(Item data, dNode previous, dNode next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public Item getData() {
            return data;
        }

        public dNode getPrevious() {
            return previous;
        }

        public dNode getNext() {
            return next;
        }

        public void setData(Item data) {
            this.data = data;
        }

        public void setPrevious(dNode previous) {
            this.previous = previous;
        }

        public void setNext(dNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }

    private dNode header;
    private dNode trailer;
    private int size;

    public DoublyLinkedList() {
        header = new dNode(null, null, null);
        trailer = new dNode(null, null, null);

        header.setNext(trailer);
        trailer.setPrevious(header);

        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Item getFirst() {
        if (!isEmpty()) {
            return (Item) header.getNext().getData();
        }
        else {
            return null;
        }
    }

    public Item getLast() {
        if (!isEmpty()) {
            return (Item) trailer.getPrevious().getData();
        }
        else {
            return null;
        }
    }

    private void addBetween(Item data, dNode previous, dNode next) {
        dNode n = new dNode (data, previous, next);

        previous.setNext(n);
        next.setPrevious(n);
    }

    public void addFirst(Item data) {
        addBetween(data, header, header.getNext());

        size++;
    }

    public void addLast(Item data) {
        addBetween(data, trailer.getPrevious(), trailer);

        size++;
    }

    private void clear() {
        header.setNext(trailer);
        trailer.setPrevious(header);
    }

    private void removeBetween(dNode previous, dNode next) {
        previous.setNext(next);
        next.setPrevious(previous);
    }


    public Item removeFirst() {
        Item it = getFirst();

        if (!isEmpty()) {
            if (size > 1) {
                removeBetween(header, header.getNext().getNext());
            }
            else {
                this.clear();
            }

            size--;
        }

        return it;
    }

    public Item removeLast() {
        Item it = getLast();

        if (!isEmpty()) {
            if (size > 1) {
                removeBetween(trailer.getPrevious().getPrevious(), trailer);
            }
            else {
                clear();
            }

            size--;
        }

        return it;
    }

    public Item findMiddle() {
        dNode forward = header.getNext();
        dNode backward = trailer.getPrevious();

        while (true) {
            if (forward == backward) {
                return (Item) forward.getData();
            }

            backward = backward.getPrevious();

            if (forward == backward) {
                return (Item) forward.getData();
            }

            forward = forward.getNext();
        }
    }

    private class ListIterator implements Iterator<Item> {
        private dNode current = header.getNext();

        public boolean hasNext() {
            return current != trailer;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        dNode temp = header.getNext();

        while (temp != trailer) {
            sb.append(temp);

            temp = temp.getNext();

            if (temp != trailer) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
