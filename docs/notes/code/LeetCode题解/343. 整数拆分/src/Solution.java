class Solution {
    private int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];
        return intBreak(n);
    }

    private int intBreak(int n) {
        if (n == 1)
            return 1;

        if (memo[n] != 0)
            return memo[n];

        int res = -1;
        for (int i = 1; i < n; i++) {
            res = max3(i * intBreak(n - i), i * (n - i), res);
        }

        memo[n] = res;
        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}