public class Shell implements Sort {

    @Override
    public void sort(int[] nums) {
        int n = nums.length;

        int h = 1;
        while (h < n / 3)
            h = h * 3 + 1;

        while (h > 0) {
            for (int i = h; i < n; i++) {
                for (int j = i; j - h >= 0; j -= h) {
                    if (nums[j] < nums[j - h])
                        swap(nums, j, j - h);
                }
            }
            h /= 3;
        }
    }
}
