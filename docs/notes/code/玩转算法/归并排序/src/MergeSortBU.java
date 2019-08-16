public class MergeSortBU implements Sort {

    @Override
    public void sort(int[] arr) {
        for (int sz = 1; sz <= arr.length; sz += sz) {
            for (int i = 0; i + sz < arr.length; i += sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(arr.length - 1, i + sz + sz - 1));
            }
        }
    }

    private void merge(int[] arr, int l, int m, int r) {

        int[] aux = new int[arr.length];
        System.arraycopy(arr, l, aux, l, r - l + 1);

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

    public static void main(String[] args) {
        MergeSortBU mergeSortBU = new MergeSortBU();

        int[] array = ArrayUtil.newArray(9);

        mergeSortBU.sort(array);
        ArrayUtil.show(array);
        ArrayUtil.check(array);
    }
}
