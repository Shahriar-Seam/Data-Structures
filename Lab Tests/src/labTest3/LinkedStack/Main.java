package labTest3.LinkedStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String in = input.nextLine();

        String post = LinkedStack.infixToPostfix(in);

        System.out.println(post);
    }
}
