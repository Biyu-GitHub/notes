class Solution {
    /**
     * 使[0, zero]区间内都为0
     * 使[two, n-1]区间内都为2
     * 使[zero+1, i]区间都为1
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;

        for (int i = 0; i < two; i++) {
            if (nums[i] == 0)
                swap(nums, ++zero, i);
            else if (nums[i] == 2)
                swap(nums, --two, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}