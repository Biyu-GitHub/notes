package practice;

class Solution2 {

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0)
            return 0;

        int[] memo = new int[n];

        memo[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int res = 0;
            for (int j = i; j < n; j++) {
                res = Math.max(res, nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
            memo[i] = res;
        }
        return memo[0];
    }
}
