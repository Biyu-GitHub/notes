package practice;

import java.util.Arrays;

class Solution {
    private int[] memo;

    private int tryRob(int[] nums, int index) {
        if (index >= nums.length)
            return 0;

        if (memo[index] != -1)
            return memo[index];

        int ret = 0;
        for (int i = index; i < nums.length; i++) {
            ret = Math.max(ret, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = ret;
        return ret;
    }

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }
}
