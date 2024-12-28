package labTest4;

public class Main {
    public static void main(String[] args) {
        X x = new X();

        x.createUser(105);
        x.createUser(115);

        x.post(105, "Skipped the gym today.");
        x.post(105, "Just saw a cat staring at a puddle.");
        x.post(115, "Big wins start with small steps.");

        x.getNewsFeed(105);

        System.out.println();

        x.getNewsFeed(115);

//        x.show();
    }
}
