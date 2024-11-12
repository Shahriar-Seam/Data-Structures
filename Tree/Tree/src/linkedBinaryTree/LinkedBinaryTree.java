package linkedBinaryTree;

import node.Node;

public class LinkedBinaryTree <Item> {
    private Node <Item> root = null;
    private int size = 0;

    private Node <Item> createNode(Item element, Node <Item> parent, Node <Item> left, Node <Item> right) {
        return new Node <Item> (element, parent, left, right);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node <Item> addRoot(Item element) {
        if (!isEmpty()) {
            return null;
        }

        root = createNode(element, null, null, null);
        size++;

        return root;
    }
}
