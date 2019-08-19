class Solution2 {
    private int[] memo;

    public int numSquares(int n) {
        memo = new int[n + 1];

        return squaresNum(n);
    }

    private int squaresNum(int n) {
        if (n == 1)
            return 1;

        if (memo[n] != 0)
            return memo[n];

        memo[n] = n;

        for (int i = 1; i * i <= n; i++) {
            memo[n] = Math.min(memo[n], squaresNum(n - i * i) + 1);
        }

        return memo[n];
    }
}