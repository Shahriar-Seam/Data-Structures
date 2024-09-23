package Week2.Stack;

import java.util.Iterator;
import java.util.Scanner;

public class ResizingArrayStackOfStrings implements Iterable <String> {
    private String[] s;
    private int N;

    public ResizingArrayStackOfStrings() {
        s = new String[1];
    }

    public void push(String item) {
        if (N == s.length) {
            resize(2 * s.length);
        }

        s[N++] = item;
    }

    public String pop() {
        String item = s[--N];
        s[N] = null;

        if (N > 0 && N == s.length / 4) {
            resize(s.length / 2);
        }

        return item;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];

        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }

        s = copy;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ResizingArrayStackOfStrings stackOfStrings = new ResizingArrayStackOfStrings();

        for (int i = 0; i < 3; i++) {
            String s = input.next();

            if (s.equals("-")) {
                System.out.println(stackOfStrings.pop());
            }
            else {
                stackOfStrings.push(s);
            }
        }

        for (String s : stackOfStrings) {
            System.out.println(s.toString());
        }
    }

    private class ListIterator implements Iterator {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public String next() {
            String ss = s[--i];

            return ss;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

    @Override
    public Iterator iterator() {
        return new ListIterator();
    }
}
