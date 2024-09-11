package Lab_Test_1;

public class Scoreboard {
    private Player[] board;
    private int size;

    public Scoreboard() {
        board = new Player[50];
        size = 0;
    }

    public void add(Player p) {
        int score = p.getScore();

        if (size < board.length || score > board[size - 1].getScore()) {
            if (size < board.length) {
                size++;
            }

            int j = size - 1;

            while (j > 0 && board[j - 1].getScore() < score) {
                board[j] = board[j - 1];

                j--;
            }

            board[j] = p;
        }
    }

    public void remove(int i) {
        if (i >= 0 && i < size) {
            for (int j = i; j < size - 1; j++) {
                board[j] = board[j + 1];
            }

            board[size - 1] = null;

            size--;
        }
    }

    public void remove(String name) {
        for (int i = 0; i < size; i++) {
            if (board[i].sameName(name)) {
                remove(i);

                i--;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(board[i]).append("\n");
        }

        sb.append("\n");

        return sb.toString();
    }
}
