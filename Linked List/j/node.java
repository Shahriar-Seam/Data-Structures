package LinkedList;

public class node <Item> {
    private Item data;
    private node next;

    public node(Item data, node next) {
        this.data = data;
        this.next = next;
    }

    public Item getData() {
        return data;
    }

    public node getNext() {
        return next;
    }

    public void setData(Item data) {
        this.data = data;
    }

    public void setNext(node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}