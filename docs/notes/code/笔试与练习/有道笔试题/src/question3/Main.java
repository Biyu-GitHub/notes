package question3;

import java.util.Scanner;

public class Main {
    // 1 3 9 2 6
    public static int maxSubList(int[] nums, int n) {
        int l = 0;
        int r = -1;
        int sum = 0;
        int res = 0;
        while (l < n) {
            while (r + 1 < n && sum <= nums[r + 1]) {
                sum += nums[++r];
            }
            res = Math.max(res, r - l + 1);
            sum -= nums[l++];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(maxSubList(nums, n));
        }
    }
}
