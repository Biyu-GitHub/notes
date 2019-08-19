class Solution2 {
    public int integerBreak(int n) {
        int[] memo = new int[n + 1];

        memo[1] = 1;

        // i 表示当前正在处理的数字，把 i 拆分成 j 和 i-j
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                memo[i] = max3(memo[i], j * memo[i-j], j * (i-j));
            }
        }

        return memo[n];
    }


    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}