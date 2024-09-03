package ScoreBoard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Scoreboard board = new Scoreboard();

        System.out.println("Enter number of entries: ");
        int entryCount = input.nextInt();

        System.out.println("Enter entries [name, score]: ");
        for (int i = 0; i < entryCount; i++) {
            String name = input.next();
            int score = input.nextInt();

            board.add(new GameEntry(name, score));

            System.out.println(board);
        }
    }
}
