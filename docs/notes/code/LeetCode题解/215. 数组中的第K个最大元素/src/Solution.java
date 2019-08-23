import java.util.Random;

class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {

        k = nums.length - k;

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int p = partition(nums, l, r);

            if (p == k)
                break;

            else if (p < k)
                l = p + 1;

            else
                r = p - 1;
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int r) {
        if (r > l)
            swap(nums, l, random.nextInt(r - l) + l + 1);

        int v = nums[l];
        int i = l + 1;
        int j = r;

        while (true) {
            while (i <= r && nums[i] < v) i++;
            while (j >= l + 1 && nums[j] > v) j--;

            if (i >= j)
                break;

            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}