package question3;

import java.util.Scanner;

public class Main {

    public static int f(int index, int c, int[] nums) {

        if (index < 0 || c <= 0)
            return 0;

        int res = f(index - 1, c, nums);

        if (c >= nums[index])
            res = Math.max(res, f(index - 1, c - nums[index], nums) + nums[index]);

        return res;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {

            int n = sc.nextInt();
            int[] nums = new int[n];

            int sum = 0;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                sum += x;
                nums[i] = x;
            }
            int minmum = f(n - 1, sum / 2, nums);
            System.out.println(Math.abs(sum - minmum * 2));
        }
    }
}
