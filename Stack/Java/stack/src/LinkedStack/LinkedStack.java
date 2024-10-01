package LinkedStack;

import SinglyLinkedList.SinglyLinkedList;

import java.sql.Statement;
import java.util.Iterator;

public class LinkedStack <Item> {
    private SinglyLinkedList <Item> stack = new SinglyLinkedList <Item> ();

    public LinkedStack() {
        // Do nothing here
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getSize() {
        return stack.getSize();
    }

    public void push(Item it) {
        stack.addFirst(it);
    }

    public Item pop() {
        Item it = top();

        stack.removeFirst();

        return it;
    }

    public Item top() {
        return stack.getFirst();
    }

    public static boolean isMatched(String expression) {
        final String opening = "({[";
        final String closing = ")}]";

        LinkedStack <Character> buffer = new LinkedStack<Character>();

        for (char c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                buffer.push(c);
            }
            else if (closing.indexOf(c) != -1) {
                if (buffer.isEmpty()) {
                    return false;
                }
                if (closing.indexOf(c) != opening.indexOf(buffer.pop())) {
                    return false;
                }
            }
        }

        return buffer.isEmpty();
    }

    public static String infixToPostfix(String expression) {
        LinkedStack <Character> buffer = new LinkedStack<Character>();
        StringBuilder postFixExpression = new StringBuilder();
        final String digits = "0123456789";
        final String operators = "-+*/";
        final String opening = "({[";
        final String closing = ")}]";

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (digits.indexOf(c) != -1) {
                while (digits.indexOf(c) != -1) {
                    postFixExpression.append(c);

                    c = expression.charAt(++i);
                }

                i--;

                postFixExpression.append(",");
            }
            else if (opening.indexOf(c) != -1) {
                buffer.push(c);
            }
            else if (operators.indexOf(c) != -1) {
                if (buffer.isEmpty()) {
                    buffer.push(c);
                }
                else if (operators.indexOf(buffer.top()) >= operators.indexOf(c)) {
                    postFixExpression.append(buffer.pop());

                    while (!buffer.isEmpty() && operators.indexOf(buffer.top()) >= operators.indexOf(c)) {
                        postFixExpression.append(buffer.pop());
                    }

                    buffer.push(c);
                }
                else {
                    buffer.push(c);
                }
            }
            else if (closing.indexOf(c) != -1) {
                while (opening.indexOf(buffer.top()) != closing.indexOf(c)) {
                    postFixExpression.append(buffer.pop());
                }

                buffer.pop();
            }
        }

        while (!buffer.isEmpty()) {
            postFixExpression.append(buffer.pop());
        }

        return postFixExpression.toString();
    }

    public static int evaluate(String expression) {
        LinkedStack <Integer> buffer = new LinkedStack<Integer>();
        final String digits = "0123456789";
        final String operators = "-+*/";

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            int a = 0, b = 0, num = 0;

            if (digits.indexOf(c) != -1) {
                num = 0;

                while (digits.indexOf(c) != -1) {
                    num *= 10;

                    num += c - '0';

                    c = expression.charAt(++i);
                }

                buffer.push(num);

                i--;

                postFixExpression.append(",");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Item it : stack) {
            sb.append(it).append(" ");
        }

        return sb.toString();
    }
}
