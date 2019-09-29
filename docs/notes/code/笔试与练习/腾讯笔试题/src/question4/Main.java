package question4;

import java.util.Scanner;

public class Main {

    public static int minmum(int[] nums, int n) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int nums[] = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(minmum(nums, n));
        }
    }
}
