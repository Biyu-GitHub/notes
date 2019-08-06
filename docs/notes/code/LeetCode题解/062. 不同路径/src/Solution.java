import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[] memo = new int[n];

        Arrays.fill(memo, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[j] += memo[j - 1];
            }
        }

        return memo[n - 1];
    }
}