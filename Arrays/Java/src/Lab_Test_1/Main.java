package Lab_Test_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Scoreboard scoreboard = new Scoreboard();

        while (true) {
            String op = input.next();

            if (op.equals("over")) {
                break;
            }

            if (op.equals("disqualify")) {
                String name = input.next();

                scoreboard.remove(name);
            }
            else {
                int score = input.nextInt();

                scoreboard.add(new Player(op, score));
            }

            System.out.println(scoreboard);
        }
    }
}
