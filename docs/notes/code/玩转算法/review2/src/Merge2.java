public class Merge2 implements Sort {
    @Override
    public void sort(int[] nums) {
        int n = nums.length;

        for (int sz = 0; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += 2 * sz + 1) {
                merge(nums, i, i + sz - 1, Math.min(n - 1, i + 2 * sz - 1));
            }

        }
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
