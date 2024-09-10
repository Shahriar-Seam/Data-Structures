package LinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.prepend(60);
        singlyLinkedList.prepend(25);
        singlyLinkedList.prepend(5);
        singlyLinkedList.append(50);

//        singlyLinkedList.remove_node(singlyLinkedList.getHead());
//        singlyLinkedList.remove_node(singlyLinkedList.getHead());
//        singlyLinkedList.remove_node(singlyLinkedList.getHead());
//        singlyLinkedList.remove_node(singlyLinkedList.getHead());

        singlyLinkedList.remove_node(singlyLinkedList.search(90));


        System.out.println(singlyLinkedList.getHead() + " " + singlyLinkedList.getTail());

        singlyLinkedList.reverse();

//        singlyLinkedList.clear();

//        singlyLinkedList.removeTail();

        singlyLinkedList.print_list();

        System.out.println("First: " + singlyLinkedList.getFirst());
        System.out.println("Last: " + singlyLinkedList.getLast());

        System.out.println("Size: " + singlyLinkedList.getSize());

        System.out.println("Tail: " + singlyLinkedList.getTail());
    }
}
