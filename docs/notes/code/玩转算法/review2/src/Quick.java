public class Quick implements Sort {
    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int l, int r) {
        if (l >= r)
            return;

        int m = partition(nums, l, r);
        sort(nums, l, m - 1);
        sort(nums, m + 1, r);
    }

    public int partition(int[] nums, int l, int r) {
        int v = nums[l];
        int i = l + 1;
        int j = r;

        while (true) {
            while (i != r && nums[i] <= v) i++;
            while (j != l + 1 && nums[j] >= v) j--;

            if (i > j)
                break;
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return l;
    }
}
