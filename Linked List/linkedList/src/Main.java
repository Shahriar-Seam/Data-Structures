import DoublyLinkedList.DoublyLinkedList;
import SinglyLinkedList.SinglyLinkedList;

public class Main {
//    public static void main(String[] args) {
////        Singly Linked List
//        SinglyLinkedList <Integer> list1 = new SinglyLinkedList<Integer>();
//        SinglyLinkedList <Integer> list2 = new SinglyLinkedList<Integer>();
//
//        list1.addLast(10);
//        list1.addLast(20);
//        list1.addLast(30);
//        list1.addLast(40);
//        list1.addLast(50);
//
//        list2.addLast(1);
//        list2.addLast(2);
//        list2.addLast(3);
//        list2.addLast(4);
//        list2.addLast(5);
//
//        System.out.println("List1:");
//        System.out.println(list1);
//
//        System.out.println("List2:");
//        System.out.println(list2);
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
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList ();

        for (int i = 1; i <= 6; i++) {
            doublyLinkedList.addLast(i);
        }

        System.out.println("Middle = " + doublyLinkedList.findMiddle());

//        doublyLinkedList.showList();
    }
}
