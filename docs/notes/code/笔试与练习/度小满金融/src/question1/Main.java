package question1;

import java.util.Scanner;

/**
 * 穿越障碍物
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 你现在在(0,0)，需要到(x,y)去，路上有n个障碍物。给出每个障碍物的坐标，你只能平行于坐标轴走整数步，问你最少需要多少步才能走到目的地。
 * <p>
 * 输入
 * 第一行三个数x,y,n
 * <p>
 * 接下来n行，每行描述一个障碍物的坐标x_i,y_i
 * <p>
 * -500≤x,y,x_i,y_i≤500
 * <p>
 * n≤10000
 * <p>
 * 保证有解
 * <p>
 * 输出
 * 输出一个数，代表最少的步数。
 * <p>
 * <p>
 * 样例输入
 * 2 0 3
 * 1 0
 * 1 1
 * 1 -1
 * 样例输出
 * 6
 */

// 从(500, 500)到(x, y)
public class Main {

    private static int res;

    public static void minmumPath(int[][] nums, int x, int y, int i, int j, int sum) {

        if (i == x && j == y) {
            res = Math.min(res, sum);
            return;
        }

        if (i < 0 || i >= 1001 || j < 0 || j >= 1001 || nums[i][j] == 1) {
            return;
        }

        nums[i][j] = 1;
        sum++;

        minmumPath(nums, x, y, i + 1, j, sum);
        minmumPath(nums, x, y, i - 1, j, sum);
        minmumPath(nums, x, y, i, j + 1, sum);
        minmumPath(nums, x, y, i, j - 1, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int x = sc.nextInt() + 500;
            int y = sc.nextInt() + 500;
            int n = sc.nextInt();

            int[][] nums = new int[1001][1001];

            for (int k = 0; k < n; k++) {
                int i = sc.nextInt() + 500;
                int j = sc.nextInt() + 500;

                nums[i][j] = 1;
            }
            res = Integer.MAX_VALUE;
            minmumPath(nums, x, y, 500, 500, 0);
            System.out.println(res);
        }
    }
}
