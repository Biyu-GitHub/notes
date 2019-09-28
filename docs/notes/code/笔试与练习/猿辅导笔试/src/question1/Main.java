package question1;

import java.util.Scanner;

public class Main {

    public static void fruit(int[][] nums, int n, int m) {
        int top = 0;
        int left = 0;
        int right = m - 1;
        int bottom = n - 1;

        while (top <= bottom && left <= right) {

            for (int i = top; i <= bottom; i++) {
                System.out.print(nums[i][left] + " ");
            }

            for (int i = left + 1; i <= right; i++) {
                System.out.print(nums[bottom][i] + " ");
            }

            for (int i = bottom - 1; left + 1 <= right && i >= top; i--) {
                System.out.print(nums[i][right] + " ");
            }

            for (int i = right - 1; top + 1 <= bottom && i >= left + 1; i--) {
                System.out.print(nums[top][i] + " ");
            }

            top++;
            bottom--;
            left++;
            right--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] nums = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }

            fruit(nums, n, m);
        }
    }
}
