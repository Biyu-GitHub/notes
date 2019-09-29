class Solution2 {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0)
            return 0;

        if (n == 1)
            return nums[0];

        for (int i = 0; i < n; i++) {
            int k1 = (i - 1 + n) % n;
            int k2 = i - 2 >= 0 ? i - 2 : i - 2 + n;

            int a = nums[k1];
            int b = nums[k2] + nums[i];

            if ((k1 + 1) % n != i && (k2 + 1) % n != i)
                nums[i] = Math.max(a, b);
        }

        int res = 0;
        for (int num : nums) {
            if (num > res)
                res = num;
        }
        return res;
    }
}