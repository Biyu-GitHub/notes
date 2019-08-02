class Solution {
    int[] memo;

    public int numTrees(int n) {
        memo = new int[n + 1];
        return numtree(n);
    }

    private int numtree(int n) {
        if (memo[n] != 0)
            return memo[n];

        if (n == 1 || n == 0) return 1;

        int ret = 0;
        for (int i = 1; i <= n; i++) {
            ret += numtree(i - 1) * numtree(n - i);
        }
        memo[n] = ret;
        return ret;
    }
}