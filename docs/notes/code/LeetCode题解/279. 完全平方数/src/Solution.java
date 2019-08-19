class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = i;
            for (int j = 1; j * j <= i; j++) {
                memo[i] = Math.min(memo[i], memo[i - j * j] + 1);
            }
        }
        return memo[n];
    }
}