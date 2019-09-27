public class MergeSortUp2Down implements Sort {

    @Override
    public void sort(int[] nums) {
        int n = nums.length;

        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz * 2) {
                merge(nums, i, i + sz - 1, Math.min(n - 1, i + sz * 2 - 1));
            }
        }
    }

    private void merge(int[] nums, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        int[] aux = new int[nums.length];

        for (int k = l; k <= r; k++) {
            aux[k] = nums[k];
        }

        for (int k = l; k <= r; k++) {
            if (i > m) {
                nums[k] = aux[j++];
            } else if (j > r) {
                nums[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }
}
