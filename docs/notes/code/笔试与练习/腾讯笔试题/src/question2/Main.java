package question2;

import java.util.Scanner;

public class Main {

    public int minmunCost(int[][] nums, int n) {

    }

    private int minmunCost(int[][] nums, int n, int index) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main();

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[][] nums = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }
            System.out.println(m.minmunCost(nums, n));
        }
    }
}
