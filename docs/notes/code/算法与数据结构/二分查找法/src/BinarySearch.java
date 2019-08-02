/**
 * 适用于有序数组
 */
public class BinarySearch {
    /**
     * 明确定义：在[l, r]中寻找target，并返回索引
     * 明确循环不变量
     *
     * @param arr
     * @param n
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int n, int target) {
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(BinarySearch.binarySearch(arr, arr.length, 9));
    }
}
