package ScoreBoard;

import java.util.Arrays;

public class Scoreboard {
    private int numEntries = 0;
    private GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public Scoreboard() {
        board = new GameEntry[3];
    }

    public void add(GameEntry entry) {
        int newScore = entry.getScore();

        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) {
                numEntries++;
            }

            int j = numEntries - 1;

            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }

            board[j] = entry;
        }
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= numEntries) {
            throw new IndexOutOfBoundsException("Invalid Index: " + i);
        }

        GameEntry entry = board[i];

        for (int j = i; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }

        board[numEntries - 1] = null;

        numEntries--;

        return entry;
    }

    @Override
    public String toString() {
        StringBuilder scoreboard = new StringBuilder("Scoreboard:\n");

        for (int i = 0; i < numEntries; i++) {
            GameEntry entry = board[i];
            scoreboard.append(entry.toString()).append("\n");
        }

        return scoreboard.toString();
    }
}