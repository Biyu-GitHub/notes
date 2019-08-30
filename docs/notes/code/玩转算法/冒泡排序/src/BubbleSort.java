public class BubbleSort implements Sort {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;

        boolean isSorted = false;

        for (int i = 0; i < n - 1 && !isSorted; i++) {

            isSorted = true;

            for (int j = 0; j + 1 < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSorted = false;
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}
