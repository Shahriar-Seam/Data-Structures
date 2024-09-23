package StackUsingArray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        StackUsingArray <Integer> stackUsingArray = new StackUsingArray<Integer>();

//        stackUsingArray.push(1);
//        stackUsingArray.push(2);
//        stackUsingArray.push(3);
//        stackUsingArray.push(4);
//        stackUsingArray.push(4);
//        stackUsingArray.push(4);
//        stackUsingArray.push(4);

//        System.out.println(stackUsingArray);


        while (true) {
            System.out.print("Enter operation: ");

            String op = input.next();

            if (op.equals("push")) {
                Integer num = input.nextInt();

                stackUsingArray.push(num);
            }
            else if (op.equals("pop")) {
                stackUsingArray.pop();
            }
            else if (op.equals("top")) {
                System.out.println("Top = " + stackUsingArray.top());
            }
            else if (op.equals("size")) {
                System.out.println("Size = " + stackUsingArray.getSize());
            }
            else if (op.equals("exit") || op.equals("quit")) {
                break;
            }
            else {
                System.out.println("Invalid Operation");
            }

            for (Integer it : stackUsingArray) {
                System.out.print(it + " ");
            }

            System.out.println();
        }

        System.out.println(stackUsingArray);
    }
}
