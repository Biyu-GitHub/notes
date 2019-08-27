package backpack01;

import java.util.Arrays;

public class Knapsack {
    private int[][] memo;

    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0)
            return 0;

        if (memo[index][c] != -1)
            return memo[index][c];

        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index])
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));

        memo[index][c] = res;
        return res;
    }

    public int knapsack(int[] w, int[] v, int c) {
        int n = w.length;
        memo = new int[n][c + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return bestValue(w, v, n - 1, c);
    }

    public static void main(String[] args) {
        int c = 5;
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};

        Knapsack k = new Knapsack();
        System.out.println(k.knapsack(w, v, c));
    }
}
