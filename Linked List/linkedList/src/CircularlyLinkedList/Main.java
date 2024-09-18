package CircularlyLinkedList;

public class Main {
    public static void main(String[] args) {
        CircularlyLinkedList <Integer> list = new CircularlyLinkedList <Integer> ();

        for (int i = 1; i < 5; i++) {
            list.addLast(i);
        }

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
