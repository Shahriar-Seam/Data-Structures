package SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList <Integer> list1 = new SinglyLinkedList <Integer> ();
        SinglyLinkedList <Integer> list2 = new SinglyLinkedList <Integer> ();

        list1.addLast(10);
        list1.addLast(20);
        list1.addLast(30);
        list1.addLast(40);
        list1.addLast(50);

        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);
        list2.addLast(5);

        SinglyLinkedList <Integer> list = list1.merge(list2);

        System.out.println(list);

        list1.clear();

        list1.addLast(2);
        list1.addLast(2);
        list1.addLast(2);
        list1.addLast(2);
        list1.addLast(4);
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(5);
        list1.addLast(5);
        list1.addLast(5);
        list1.addLast(4);
        list1.addLast(3);

//        list1.removeDuplicates();
//
//        System.out.println(list1);
//
//        list1.removeIfGreaterValueExistsLater();
//
//        System.out.println(list1);

        System.out.println("List1:");
        for (Integer i : list1) {
            System.out.print(i + " ");
        }
    }
}
