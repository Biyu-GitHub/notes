public class MergeSort implements Sort {

    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        sort(nums, 0, n - 1);
    }

    private void sort(int[] nums, int l, int r) {
        if (l >= r)
            return;

        int m = l + (r - l) / 2;
        sort(nums, l, m);
        sort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r) {
        int[] aux = new int[nums.length];

        for (int k = l; k <= r; k++)
            aux[k] = nums[k];

        int i = l;
        int j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) nums[k] = aux[j++];
            else if (j > r) nums[k] = aux[i++];
            else if (aux[i] <= aux[j]) nums[k] = aux[i++];
            else nums[k] = aux[j++];
        }
    }
}
