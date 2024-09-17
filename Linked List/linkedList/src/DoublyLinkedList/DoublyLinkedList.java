package DoublyLinkedList;

import Node.Node;

public class DoublyLinkedList {
    private class dNode {
        private int data;
        private dNode previous;
        private dNode next;

        public dNode(int data, dNode previous, dNode next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public dNode getPrevious() {
            return previous;
        }

        public dNode getNext() {
            return next;
        }

        public void setData(int data) {
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
        header = new dNode(-1, null, null);
        trailer = new dNode(-1, null, null);

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

    public int getFirst() {
        if (!isEmpty()) {
            return (int) header.getNext().getData();
        }
        else {
            return -1;
        }
    }

    public int getLast() {
        if (!isEmpty()) {
            return (int) trailer.getPrevious().getData();
        }
        else {
            return -1;
        }
    }

    private void addBetween(int data, dNode previous, dNode next) {
        dNode n = new dNode (data, previous, next);

        previous.setNext(n);
        next.setPrevious(n);
    }

    public void addFirst(int data) {
        addBetween(data, header, header.getNext());

        size++;
    }

    public void addLast(int data) {
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


    public int removeFirst() {
        int it = getFirst();

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

    public int removeLast() {
        int it = getLast();

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

    public int findMiddle() {
        dNode forward = header.getNext();
        dNode backward = trailer.getPrevious();

        while (true) {
            if (forward == backward) {
                return (int) forward.getData();
            }

            backward = backward.getPrevious();

            if (forward == backward) {
                return (int) forward.getData();
            }

            forward = forward.getNext();
        }
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
