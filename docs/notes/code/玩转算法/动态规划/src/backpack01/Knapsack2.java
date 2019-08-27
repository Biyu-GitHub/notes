package backpack01;

public class Knapsack2 {

    public int knapsack(int[] w, int[] v, int c) {
        int n = w.length;

        if (n == 0)
            return 0;

        int[][] memo = new int[n][c + 1];

        for (int j = 0; j <= c; j++) {
            memo[0][j] = (j >= w[0] ? v[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i])
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
            }
        }
        return memo[n - 1][c];
    }

    public static void main(String[] args) {
        int c = 5;
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};

        Knapsack2 k = new Knapsack2();
        System.out.println(k.knapsack(w, v, c));
    }
}
