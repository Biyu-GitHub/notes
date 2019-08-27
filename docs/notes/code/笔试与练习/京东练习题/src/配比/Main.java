package 配比;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/290d29b66ca942dbb19f6268025c3727
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int A = 0; // 比例之和

            int n = sc.nextInt(); // 原料的种类
            int V = sc.nextInt(); // 需要配比的最大容量

            int[] numsA = new int[n];

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                A += x;
                numsA[i] = x;
            }
            double per_A = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                per_A = Math.min(per_A, (sc.nextInt() * 1.0 / numsA[i]));
            }
            double sum = per_A * A;

            System.out.println(String.format("%.4f", (sum < V ? sum : V * 1.0)));
        }
    }
}
