import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;

        if (n == 1) return nums[0];

        int[] memo1 = new int[n];
        int[] memo2 = new int[n];

        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);

        return Math.max(tryRob(nums, 0, nums.length - 2, memo1), tryRob(nums, 1, nums.length - 1, memo2));
    }

    private int tryRob(int[] nums, int s, int e, int[] memo) {
        if (s > e)
            return 0;

        if (memo[s] != -1)
            return memo[s];

        int res = 0;
        for (int i = s; i <= e; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2, e, memo));
        }
        memo[s] = res;
        return res;
    }
}
