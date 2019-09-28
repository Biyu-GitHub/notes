package 背包_01背包问题;

import java.util.Arrays;

public class Knapsack1 {
    private int[][] memo;

    /**
     * @param w     物品所占的空间
     * @param v     物品的价值
     * @param index 物品的id
     * @param C     背包的容积
     * @return
     */
    private int bestValue(int[] w, int[] v, int index, int C) {

        if (index < 0 || C <= 0)
            return 0;

        if (memo[index][C] != -1)
            return memo[index][C];

        int res = bestValue(w, v, index - 1, C);

        if (C - w[index] >= 0)
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, C - w[index]));

        memo[index][C] = res;

        return res;
    }

    public int knapsasck01(int[] w, int[] v, int C) {
        int n = w.length;

        memo = new int[n][C + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return bestValue(w, v, n - 1, C);
    }
}
