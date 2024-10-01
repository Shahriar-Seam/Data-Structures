package LabTest2;

import Node.Node;
import SinglyLinkedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList <Integer> list1 = new SinglyLinkedList<Integer>();
        SinglyLinkedList <Integer> list2 = new SinglyLinkedList<Integer>();

        list1.addLast(10);
        list1.addLast(20);
        Node <Integer> last = list1.getTail();

        list1.addLast(30);


        list1.addLast(40);

        list2.addLast(50);
        list2.addLast(60);
        list2.addLast(70);

        list1.merge(list2, last);

        System.out.println("First List: " + list1);
        System.out.println("Second List: " + list2);
        System.out.println("Merging element: " + list1.mergingPoint(list2));
    }
}
