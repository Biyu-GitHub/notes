import java.util.Arrays;

/**
 * 递归
 * 函数定义：抢劫[x, n-1]之中的房子，
 * 所以，f(n) = max()
 */
class Solution2 {
    private int[] memo;

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;

        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return rob(nums, 0);
    }

    private int rob(int[] nums, int x) {
        // 递归终止条件
        if (x >= nums.length)
            return 0;

        if (memo[x] != -1)
            return memo[x];

        int ret = 0;
        for (int i = x; i < nums.length; i++) {
            ret = Math.max(ret, nums[i] + rob(nums, i + 2));
        }

        memo[x] = ret;
        return ret;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
