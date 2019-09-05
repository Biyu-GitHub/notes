public class Insertion implements Sort {

    @Override
    public void sort(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (nums[j] < nums[j - 1])
                    swap(nums, j, j - 1);
            }
        }
    }
}
