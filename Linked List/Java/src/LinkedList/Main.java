package LinkedList;

public class Main {
//    public static void main(String[] args) {
////        Singly Linked List
//        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
//
//        singlyLinkedList.prepend(60);
//        singlyLinkedList.prepend(25);
//        singlyLinkedList.prepend(5);
//        singlyLinkedList.append(50);
//
////        singlyLinkedList.remove_node(singlyLinkedList.getHead());
////        singlyLinkedList.remove_node(singlyLinkedList.getHead());
////        singlyLinkedList.remove_node(singlyLinkedList.getHead());
////        singlyLinkedList.remove_node(singlyLinkedList.getHead());
//
//        singlyLinkedList.remove_node(singlyLinkedList.search(90));
//
//
//        System.out.println(singlyLinkedList.getHead() + " " + singlyLinkedList.getTail());
//
//        singlyLinkedList.reverse();
//
////        singlyLinkedList.clear();
//
////        singlyLinkedList.removeTail();
//
//        singlyLinkedList.print_list();
//
//        System.out.println("First: " + singlyLinkedList.getFirst());
//        System.out.println("Last: " + singlyLinkedList.getLast());
//
//        System.out.println("Size: " + singlyLinkedList.getSize());
//
//        System.out.println("Tail: " + singlyLinkedList.getTail());
//    }

//    public static void main(String[] args) {
//        CircularlyLinkedList <Integer> circularlyLinkedList = new CircularlyLinkedList <Integer> ();
//
//        circularlyLinkedList.addFirst(5);
//        circularlyLinkedList.addFirst(2);
//        circularlyLinkedList.addFirst(1);
//        circularlyLinkedList.addLast(9);
//
////        circularlyLinkedList.removeFirst();
////        circularlyLinkedList.removeFirst();
////        circularlyLinkedList.removeFirst();
////        circularlyLinkedList.removeFirst();
////        circularlyLinkedList.removeFirst();
//
//        circularlyLinkedList.rotate();
//        circularlyLinkedList.rotate();
//
//        circularlyLinkedList.showList();
//    }

    public static void main(String[] args) {
        DoublyLinkedList <Integer> doublyLinkedList = new DoublyLinkedList<Integer>();

        doublyLinkedList.addFirst(5);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addFirst(1);
        doublyLinkedList.addLast(9);

//        doublyLinkedList.removeFirst();
//        doublyLinkedList.removeFirst();
//        doublyLinkedList.removeFirst();
//        doublyLinkedList.removeFirst();
//        doublyLinkedList.removeFirst();

        doublyLinkedList.removeLast();
        doublyLinkedList.removeLast();
        doublyLinkedList.removeLast();
        doublyLinkedList.removeLast();
        doublyLinkedList.removeLast();

        doublyLinkedList.showList();
    }
}
