public class ReviewMergeSortBU implements Sort {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(i + 2 * sz, n - 1));
            }
        }
    }

    public void merge(int[] arr, int l, int m, int r) {
        int[] aux = new int[arr.length];

        for (int k = l; k <= r; k++)
            aux[k] = arr[k];

        int i = l;
        int j = m + 1;

        for (int k = l; k <= r; k++) {
            if (i > m)
                arr[k] = aux[j++];
            else if (j > r)
                arr[k] = aux[i++];
            else if (aux[i] <= aux[j])
                arr[k] = aux[i++];
            else
                arr[k] = aux[j++];
        }
    }
}
