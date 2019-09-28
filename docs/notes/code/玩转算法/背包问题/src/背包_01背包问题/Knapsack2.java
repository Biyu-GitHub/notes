package 背包_01背包问题;

public class Knapsack2 {

    public int knapsack(int[] w, int[] v, int c) {

        assert w.length == v.length;

        int n = w.length;

        int[][] memo = new int[n][c + 1];

        // 初始化第一行，如果能放进去，则价值就为第一个物品的价值
        for (int j = 0; j <= c; j++)
            memo[0][j] = j >= w[0] ? v[0] : 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i])
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
            }
        }
        return memo[n - 1][c];
    }
}
