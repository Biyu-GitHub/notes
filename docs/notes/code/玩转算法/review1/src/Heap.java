public class Heap implements Sort {

    @Override
    public void sort(int[] nums) {
        int n = nums.length - 1;

        for (int i = n / 2; i >= 0; i--)
            siftDown(nums, i, n);

        while (n >= 0) {
            swap(nums, 0, n--);
            siftDown(nums, 0, n);
        }
    }

    private int leftChild(int k) {
        return 2 * k + 1;
    }

    private void siftDown(int[] nums, int k, int n) {
        while (leftChild(k) <= n) {
            int j = leftChild(k);
            if (j + 1 <= n && nums[j] < nums[j + 1])
                j = j + 1;

            if (nums[k] >= nums[j])
                break;
            swap(nums, k, j);
            k = j;
        }
    }
}
