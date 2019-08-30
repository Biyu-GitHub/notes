public class HeapSort implements Sort {
    @Override
    public void sort(int[] arr) {
        int n = arr.length - 1;

        // 建立最大堆
        for (int i = n / 2; i >= 0; i--) {
            siftDown(arr, i, n);
        }

        while (n > 0) {
            swap(arr, 0, n--);
            siftDown(arr, 0, n);
        }
    }

    /**
     * 计算左孩子的index
     *
     * @param k 父亲节点的index
     * @return
     */
    private int leftChild(int k) {
        return 2 * k + 1;
    }

    /**
     * @param arr 原始数组
     * @param k   要下沉的节点的编号
     * @param n   最后的元素的index，闭区间
     */
    private void siftDown(int[] arr, int k, int n) {
        while (leftChild(k) <= n) {
            int j = leftChild(k);

            if (j + 1 <= n && arr[j] < arr[j + 1])
                j++;

            if (arr[k] >= arr[j])
                break;

            swap(arr, k, j);
            k = j;
        }
    }
}
