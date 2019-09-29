package question2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 发饼干，要求挨着的小朋友评分高的，饼干要多余评分低的，且每人至少一块
 * 例如：3, 6, 3, 5, 6, 2
 * 饼干：1, 2, 1, 2, 3, 1
 */
public class Main {

    private static void minmumCookie(int[] nums, int[] aux, int n) {

        if (nums[0] > nums[1])
            aux[0] += 1;

        if (nums[n - 1] > nums[n - 2])
            aux[n - 1] += 1;

        for (int i = 1; i + 1 < n; i++) {
            if (nums[i] >= nums[i - 1] || nums[i] >= nums[i + 1]) {
                int v = nums[i];
                int l = nums[i - 1];
                int r = nums[i + 1];

                if (v == l && aux[i] < aux[i - 1])
                    aux[i] = aux[i - 1];

                if (v == r && aux[i] < aux[i + 1])
                    aux[i] = aux[i + 1];

                if (v >= l && v >= r)
                    aux[i] = Math.max(aux[i - 1], aux[i + 1]) + 1;
                else if (v >= l)
                    aux[i] = aux[i - 1] + 1;
                else
                    aux[i] = aux[i + 1] + 1;
            }
        }

        for (int i = n - 2; i >= 1; i--) {
            if (nums[i] >= nums[i - 1] || nums[i] >= nums[i + 1]) {
                int v = nums[i];
                int l = nums[i - 1];
                int r = nums[i + 1];

                if (v == l && aux[i] < aux[i - 1])
                    aux[i] = aux[i - 1];

                if (v == r && aux[i] < aux[i + 1])
                    aux[i] = aux[i + 1];

                if (v >= l && v >= r)
                    aux[i] = Math.max(aux[i - 1], aux[i + 1]) + 1;
                else if (v >= l)
                    aux[i] = aux[i - 1] + 1;
                else
                    aux[i] = aux[i + 1] + 1;
            }
        }
    }

    public static int minmumCookie(int[] nums, int n) {
        if (n == 1)
            return 1;

        if (n == 2) {
            if (nums[0] == nums[1])
                return 2;
            else
                return 3;
        }

        int[] aux = new int[n];
        Arrays.fill(aux, 1);

        minmumCookie(nums, aux, n);

        int res = 0;
        for (int x : aux) {
            res += x;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(minmumCookie(nums, n));
        }
    }
}
