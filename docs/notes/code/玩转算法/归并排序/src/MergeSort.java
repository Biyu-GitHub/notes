/**
 * 归并排序的递归方法
 */
public class MergeSort implements Sort {

    private int[] aux;

    @Override
    public void sort(int[] arr) {
        aux = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }

    // 定义排序的区间是 [l, r] 闭区间
    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    // 归并方法
    private void merge(int[] arr, int l, int mid, int r) {

        System.arraycopy(arr, l, aux, l, r - l + 1);

        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid)
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
        int[] arr = ArrayUtil.newArray(100000);
        ArrayUtil.show(arr);

        MergeSort mergeSort = new MergeSort();

        mergeSort.sort(arr);
        ArrayUtil.show(arr);
        ArrayUtil.check(arr);
    }
}
