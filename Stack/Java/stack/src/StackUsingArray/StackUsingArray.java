package StackUsingArray;

public class StackUsingArray <Item> {
    private Item stack;
    private int size;
    private int capacity;

    public StackUsingArray() {
        capacity = 1;
        size = 0;
        stack = new Item[capacity];
    }
}
