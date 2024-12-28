package labTest4;

public class X {
    private Post[] hashMap;
    private final int capacity = 100;

    // Helper class
    private class Post {
        private int userId;
        private String message;

        public Post(int userId, String message) {
            this.userId = userId;
            this.message = message;
        }

        public int getUserId() {
            return userId;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }

    public X() {
        hashMap = new Post[capacity];
    }

    public void createUser(int userId) {
        int index = hashLast(userId);

        hashMap[index] = new Post(userId, null);
    }

    public void post(int userId, String message) {
        int index = hashLast(userId);

        if (hashMap[index] == null) {
            hashMap[index] = new Post(userId, message);
        }

        hashMap[index].setMessage(message);
    }

    public void getNewsFeed(int userId) {
        int index = hashFirst(userId);

        while (hashMap[index] != null && hashMap[index].getUserId() == userId) {
            System.out.println(hashMap[index].getMessage());

            index++;
        }
    }

    // Helper methods
    private int hashFirst(int userId) {
        int index = userId % capacity;

        if (hashMap[index] == null) {
            return index;
        }

        while (hashMap[index] != null && hashMap[index].getUserId() != userId) {
            index++;
        }

        return index;
    }

    private int hashLast(int userId) {
        int index = hashFirst(userId);

        if (hashMap[index] == null) {
            return index;
        }

        while (hashMap[index] != null && (hashMap[index].getUserId() == userId && hashMap[index].getMessage() != null)) {
            index++;
        }

        return index;
    }

    // Debug methods
    public void show() {
        for (Post p : hashMap) {
            if (p != null) {
                System.out.println(p.getUserId() + " " + p.getMessage());
            }
        }
    }
}
