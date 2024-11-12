package node;

public class Node <Item> {
    private Item element;
    private Node <Item> parent;
    private Node <Item> left;
    private Node <Item> right;

    public Node(Item element, Node<Item> parent, Node<Item> left, Node<Item> right) {
        this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public Item getElement() {
        return element;
    }

    public void setElement(Item element) {
        this.element = element;
    }

    public Node<Item> getParent() {
        return parent;
    }

    public void setParent(Node<Item> parent) {
        this.parent = parent;
    }

    public Node<Item> getLeft() {
        return left;
    }

    public void setLeft(Node<Item> left) {
        this.left = left;
    }

    public Node<Item> getRight() {
        return right;
    }

    public void setRight(Node<Item> right) {
        this.right = right;
    }
}
