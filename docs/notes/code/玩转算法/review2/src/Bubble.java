public class Bubble implements Sort {
    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        boolean isSorted = false;
        for (int i = 0; !isSorted && i < n; i++) {
            isSorted = true;
            for (int j = 0; j + 1 < n - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    isSorted = false;
                    swap(nums, i, j);
                }
            }
        }
    }
}
