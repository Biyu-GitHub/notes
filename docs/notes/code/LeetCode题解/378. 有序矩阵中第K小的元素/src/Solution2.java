class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int j = n - 1;
            for (int i = 0; i < n; i++) {
                // 找到第一个 <= mid的值
                while (j >= 0 && matrix[i][j] > mid)
                    j--;
                count = count + j + 1; // 计算当前找到的值的排名，即小于等于mid的数的排名
            }
            if (count < hi)
                lo = mid + 1;
            else
                hi = mid + 1;
        }
        return lo;
    }
}