package LinkedStack;

import SinglyLinkedList.SinglyLinkedList;

import java.util.Iterator;

public class LinkedStack <Item> implements Iterable <Item> {
    private SinglyLinkedList <Item> stack = new SinglyLinkedList <Item> ();

    public LinkedStack() {
        // Do nothing here
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getSize() {
        return stack.getSize();
    }

    public void push(Item it) {
        stack.addFirst(it);
    }

    public Item pop() {
        Item it = top();

        stack.removeFirst();

        return it;
    }

    public Item top() {
        return stack.getFirst();
    }

    @Override
    public Iterator<Item> iterator() {
        return stack.iterator();
    }
}
