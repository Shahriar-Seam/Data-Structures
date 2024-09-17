package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList ();

        for (int i = 1; i <= 6; i++) {
            doublyLinkedList.addLast(i);
        }

        System.out.println("Middle = " + doublyLinkedList.findMiddle());

        System.out.println(doublyLinkedList);
    }
}
