package question2;

import java.util.Scanner;

public class Main {
    public static void calOutStudent(int[][] arr, int n) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] arr = new int[2*n][2*n];

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                if (x < y)
                    arr[x][y] = 1;
                else
                    arr[y][x] = 1;
            }
            System.out.println(1);
            System.out.println(1);
        }
    }
}
