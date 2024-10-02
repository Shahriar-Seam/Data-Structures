package ArrayQueue;

public class Main {
    public static void main(String[] args) {
        ArrayQueue <Integer> queue = new ArrayQueue<Integer>();

        System.out.println(queue.first());

        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(3);

        System.out.println(queue + "s = " + queue.length());

        queue.dequeue();

        System.out.println(queue + "s = " + queue.length());

        queue.dequeue();

        queue.enqueue(12);
        queue.enqueue(15);
        queue.enqueue(19);
        queue.enqueue(20);
        queue.enqueue(21);

        queue.dequeue();

        queue.dequeue();

        queue.enqueue(25);
        queue.enqueue(26);
        queue.enqueue(27);


        System.out.println(queue + "s = " + queue.length());

        queue.dequeue();

        System.out.println(queue + "s = " + queue.length());

        queue.dequeue();

        System.out.println(queue + "s = " + queue.length());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println(queue + "s = " + queue.length());
    }
}
