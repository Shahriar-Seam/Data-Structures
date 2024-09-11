package Lab_Test_1;

public class Player {
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public boolean sameName(String name) {
        return this.name.equals(name);
    }

    @Override
    public String toString() {
        return this.name + " " + this.score;
    }
}
