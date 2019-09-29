public class Two048 {

    public static void move2048(int[][] nums, int n) {

        for (int i = 0; i < n; i++) {
            int j = 0;
            int k = 0; // k记录当前有几个值，用于后面补零的个数
            while (j < n) {
                if (nums[i][j] == 0) { // 不处理为0的情况
                    j++;
                    continue;
                }
                // 两个连续的值相等，输出结果x2，j跳2格
                if (j + 1 < n && nums[i][j] == nums[i][j + 1]) {
                    System.out.print(nums[i][j] * 2 + " ");
                    j += 2;
                    k++;
                } else { // 否则直接输出当前值，j跳一格
                    System.out.print(nums[i][j] + " ");
                    j++;
                    k++;
                }
            }
            while (k < n) { // 补0
                System.out.print(0 + " ");
                k++;
            }
            System.out.println(); // 换行
        }
    }

    public static void main(String[] args) {
        int[][] nums = {
                {0, 0, 2, 4},
                {0, 2, 2, 2},
                {0, 4, 2, 2},
                {8, 8, 2, 2}
        };

        move2048(nums, 4);
    }
}
