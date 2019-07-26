/**
 * 递归
 * 函数定义：抢劫[x, n-1]之中的房子，
 * 所以，f(n) = max()
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;

        return rob(nums, 0);
    }

    private int rob(int[] nums, int x) {
        // 递归终止条件
        if (x >= nums.length)
            return 0;

        int ret = 0;
        for (int i = x; i < nums.length; i++) {
            ret = Math.max(ret, nums[i] + rob(nums, i + 2));
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
