public class Selection implements Sort {
    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min])
                    min = j;
            }
            swap(nums, i, min);
        }
    }
}
