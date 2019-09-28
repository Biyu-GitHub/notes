package question1;

import java.util.Scanner;

public class Main {

    public static boolean isIllegal(String input) {

        String[] strings = input.split(" ");
        int n = strings.length;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = strings[i].length();
        }

        // 1. 交替出现
        boolean res = true;

        int len1 = nums[0];
        int len2 = nums[1];

        if (!((len1 == 1 && len2 == 2) || (len1 == 2 && len2 == 1)))
            res = false;

        for (int i = 0; res && i + 2 < n; i += 2) {
            if (nums[i] != len1) {
                res = false;
                break;
            }

        }

        for (int i = 1; res && i + 2 < n; i += 2) {
            if (nums[i] != len2) {
                res = false;
                break;
            }
        }

        if (res)
            return true;

        // 2. 首位两位，其他一位，则要求至少三位
        res = true;

        if (nums[0] != 2 || nums[n - 1] != 2)
            res = false;

        for (int i = 1; res && i < n - 1; i++) {
            if (nums[i] != 1) {
                res = false;
                break;
            }
        }

        if (res)
            return true;

        // 3. 首位一位，其他两位，则要求至少三位
        res = true;

        if (nums[0] != 1 || nums[n - 1] != 1)
            res = false;

        for (int i = 1; res && i < n - 1; i++) {
            if (nums[i] != 2) {
                res = false;
                break;
            }
        }

        if (res)
            return true;

        return false;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            String s = sc.nextLine();
            System.out.print(isIllegal(s) + " ");
        }
    }
}
