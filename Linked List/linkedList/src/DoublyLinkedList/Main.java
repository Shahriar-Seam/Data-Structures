package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList <Integer> doublyLinkedList = new DoublyLinkedList <Integer> ();

        for (int i = 1; i <= 6; i++) {
            doublyLinkedList.addLast(i);
        }

        System.out.println("Middle = " + doublyLinkedList.findMiddle());

//        System.out.println(doublyLinkedList);

        for (Integer i : doublyLinkedList) {
            System.out.print(i + " ");
        }
    }
}
