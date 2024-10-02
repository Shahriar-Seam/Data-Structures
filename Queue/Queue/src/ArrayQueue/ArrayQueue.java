package ArrayQueue;

public class ArrayQueue <Item> {
    private Item[] data;
    private int f = 0;
    private int sz = 0;

    public ArrayQueue() {
        this(1);
    }

    public ArrayQueue(int capacity) {
        data = (Item[]) new Object[capacity];
    }

    public int size() {
        return sz;
    }

    public boolean isEmpty() {
        return sz == 0;
    }

    public void enqueue(Item e) {
        if (sz == data.length) {
            resize(data.length * 2);
        }

        int avail = (f + sz) % data.length;
        data[avail] = e;
        sz++;
    }

    public Item first() {
        return data[f];
    }

    public Item dequeue() {
        if (isEmpty()) {
            return null;
        }

        Item top = data[f];

        data[f] = null;

        f = (f + 1) % data.length;

        sz--;

        if (sz == data.length / 4) {
            resize(data.length / 2);
        }

        return top;
    }

    public void resize(int capacity) {
        Item[] temp = (Item []) new Object[capacity];

        for (int i = f; i < f + sz; i++) {
            temp[(i - f) % data.length] = data[i % data.length];
        }

        data = temp;

        f = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = f; i < f + sz; i++) {
            sb.append(data[i % data.length]).append(" ");
        }

        return sb.toString();
    }

    // Debugging methods
    public int length() {
        return data.length;
    }

    public int getF() {
        return f;
    }
}
