package question2;

import java.util.Scanner;

public class Main {

    public static int maxmumCourses(int[] nums, int s) {

        int n = nums.length;
        int l = 0, r = -1;
        int sum = 0;
        int ret = 0;

        while (l < n) {
            while (r + 1 < n && sum + nums[r + 1] <= s)
                sum += nums[++r];

            ret = Math.max(ret, r - l + 1);

            sum -= nums[l++];
        }

        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(maxmumCourses(nums, s));
        }
    }
}
