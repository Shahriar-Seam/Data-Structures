package labTest3;

import labTest3.LinkedStack.LinkedStack;

public class EulerTourTraversal {
    public static void traverseRecursive(int[] tree, int index) {
        if (index < tree.length) {
            System.out.printf(tree[index] + " ");

            if (2 * index + 1 < tree.length && tree[2 * index + 1] != 0) {
                traverseRecursive(tree, index * 2 + 1);
                System.out.printf(tree[index] + " ");
            }

            if (2 * index + 2 < tree.length && tree[2 * index + 2] != 0) {
                traverseRecursive(tree, index * 2 + 2);
                System.out.printf(tree[index] + " ");
            }
        }
    }

    public static void traverse(int[] tree, int start) {
        LinkedStack <Integer> stack = new LinkedStack<Integer>();
        boolean[] visited = new boolean[tree.length];
        int presentIndex = start;

        if (tree[start] == 0) {
            System.out.println("Not a Tree");

            return;
        }

        stack.push(tree[start]);

        while (!stack.isEmpty()) {
            System.out.printf(stack.top() + " ");
            visited[presentIndex] = true;

            if ((2 * presentIndex + 1 < tree.length) && (tree[2 * presentIndex + 1] != 0) && !visited[2 * presentIndex + 1]) {
                stack.push(tree[2 * presentIndex + 1]);

                presentIndex = 2 * presentIndex + 1;

                visited[presentIndex] = true;
            }
            else if ((2 * presentIndex + 2 < tree.length) && (tree[2 * presentIndex + 2] != 0) && !visited[2 * presentIndex + 2]) {
                stack.push(tree[2 * presentIndex + 2]);

                presentIndex = 2 * presentIndex + 2;

                visited[presentIndex] = true;
            }
            else {
                stack.pop();

                presentIndex = (presentIndex - 1) / 2;
            }
        }
    }

    public static void show(int[] tree) {
        int len = tree.length;

        for (int i = 0, k = 0; i < Math.log(len) / Math.log(2); i++) {
            for (int j = 0; j < len - i; j++) {
                System.out.printf(" ");
            }

            for (int j = 0; j < (1 << i) && k < len; j++, k++) {
                System.out.printf(tree[k] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] tree = {1, 5, 0, 4, 0, 0, 0, 2, 3};
//        int[] tree = {1, 2, 3, 4, 5, 0, 6};
//        int[] tree = {1, 0, 3, 0, 0, 0, 4};
//        int[] tree = {0, 0, 0, 0, 0, 0, 0};

        traverse(tree, 1);

        System.out.println();

        traverseRecursive(tree, 0);

        System.out.println();

        show(tree);
    }
}
