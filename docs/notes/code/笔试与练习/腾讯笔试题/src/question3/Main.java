package question3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String minmum(int[] nums, int n) {
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                sb.insert(0, nums[i] + " ");
            else
                sb.append(nums[i] + " ");
        }
        return String.join(" ", sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(minmum(nums, n));
    }
}
