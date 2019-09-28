public class Heap implements Sort {
    @Override
    public void sort(int[] nums) {
        int n = nums.length - 1;
        for (int i = n / 2; i > 0; i--) {
            siftDowm(nums, i, n);
        }

        while (n >= 0) {
            swap(nums, 0, n--);
            siftDowm(nums, 0, n);
        }
    }

    public int leftChild(int k) {
        return k * 2 + 1;
    }

    public void siftDowm(int[] nums, int k, int n) {
        while (leftChild(k) <= n) {
            int j = leftChild(k);

            if (j + 1 <= n && nums[j + 1] > nums[j])
                j = j + 1;

            if (nums[k] >= nums[j])
                break;
            swap(nums, k, j);
            k = j;
        }
    }
}
