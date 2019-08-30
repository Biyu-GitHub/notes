public class InsertionSort implements Sort {
    @Override
    public void sort(int[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
                else
                    break;
            }
        }
    }
}
