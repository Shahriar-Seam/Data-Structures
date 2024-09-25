package LinkedStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        LinkedStack <Character> stack = new LinkedStack<Character>();

        String s = input.nextLine();
        boolean valid = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (!stack.isEmpty()) {
                if ((c == ')' && stack.top() == '(') || (c == '}' && stack.top() == '{') || (c == ']' && stack.top() == '[')) {
                    stack.pop();
                }
                else {
                    valid = false;

                    break;
                }
            }
            else {
                valid = false;
                break;
            }
        }

        System.out.println(valid && stack.isEmpty() ? "Valid" : "Invalid");

        System.out.println(stack.getSize());

        for (Character c : stack) {
            System.out.print(c + " ");
        }
    }
}
