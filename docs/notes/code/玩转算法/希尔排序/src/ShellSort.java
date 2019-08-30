public class ShellSort implements Sort {
    @Override
    public void sort(int[] arr) {

        int n = arr.length;
        int h = 1;

        while (h < n / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (int i = h; i < n; i++) {
                for (int j = i; j - h >= 0; j -= h) {
                    if (arr[j] < arr[j - h])
                        swap(arr, j, j - h);
                    else
                        break;
                }
            }

            h /= 3;
        }
    }
}
