package question3;

import java.util.Scanner;

/**
 * 矩阵的最短路径，动态规划
 */
public class Main {

    public static int minmumPath(int[][] nums, int m, int n) {
        int[][] aux = new int[m][n];
        aux[0][0] = nums[0][0];

        // 初始化第一行
        for (int j = 1; j < n; j++) {
            aux[0][j] = aux[0][j - 1] + nums[0][j];
        }

        // 初始化第一列
        for (int i = 1; i < m; i++) {
            aux[i][0] = aux[i - 1][0] + nums[i][0];
        }

        // 计算最小路径

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                aux[i][j] = Math.min(aux[i - 1][j], aux[i][j - 1]) + nums[i][j];
            }
        }
        return aux[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            int[][] nums = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }
            System.out.println(minmumPath(nums, m, n));
        }
    }
}
