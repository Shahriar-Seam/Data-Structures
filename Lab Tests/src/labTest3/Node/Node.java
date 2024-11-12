package labTest3.Node;

public class Node <Item> {
    private Item data;
    private Node next;

    public Node(Item data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Item getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(Item data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}