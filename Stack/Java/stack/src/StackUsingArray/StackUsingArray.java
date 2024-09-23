package StackUsingArray;

import java.util.Iterator;

public class StackUsingArray <Item> implements Iterable <Item> {
    private Item[] stack;
    private int size;

    public StackUsingArray() {
        size = 0;
        stack = (Item[]) new Object[1];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Item it) {
        if (size == stack.length) {
            resize(stack.length * 2);
        }

        stack[size] = it;
        size++;
    }

    public Item pop() {
        if (!isEmpty()) {
            Item it = stack[size - 1];

            size--;

            stack[size] = null;

            if (size > 0 && size <= stack.length / 4) {
                resize(stack.length / 2);
            }

            return it;
        }
        else {
            return null;
        }
    }

    public Item top() {
        if (!isEmpty()) {
            return stack[size - 1];
        }
        else {
            return null;
        }
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            temp[i] = stack[i];
        }

        stack = temp;
    }

    private class ListIterator implements Iterator <Item> {
        private int index = size;

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public Item next() {
            Item item = stack[--index];

            return item;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = size - 1; i >= 0; i--) {
            sb.append(stack[i]).append(" ");
        }

        return sb.toString();
    }
}
