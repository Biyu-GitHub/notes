import java.util.Random;

public class QuickSort implements Sort {
    Random random = new Random();

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return;

        int p = partition2(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        swap(arr, l, random.nextInt(r - l + 1) + l);

        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr, i, j + 1);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    private int partition2(int[] arr, int l, int r) {
        swap(arr, l, random.nextInt(r - l + 1) + l);
        int v = arr[l];

        int i = l + 1;
        int j = r;

        while (true) {
            while (i <= r && arr[i] < v) i++;
            while (j >= l + 1 && arr[j] > v) j--;

            if (i > j)
                break;

            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int[] arr = ArrayUtil.newArray(1003);
        quickSort.sort(arr);
        ArrayUtil.show(arr);
        ArrayUtil.check(arr);
    }
}
