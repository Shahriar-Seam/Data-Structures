package LinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.prepend(60);
        singlyLinkedList.prepend(25);
        singlyLinkedList.prepend(5);
        singlyLinkedList.append(50);

        singlyLinkedList.remove_node(singlyLinkedList.getHead());
        singlyLinkedList.remove_node(singlyLinkedList.getHead());
        singlyLinkedList.remove_node(singlyLinkedList.getHead());
//        singlyLinkedList.remove_node(singlyLinkedList.getHead());


        System.out.println(singlyLinkedList.getHead().getNext() + " " + singlyLinkedList.getTail().getNext());
        singlyLinkedList.print_list();

//        System.out.println(singlyLinkedList.getTail().getData());
    }
}
