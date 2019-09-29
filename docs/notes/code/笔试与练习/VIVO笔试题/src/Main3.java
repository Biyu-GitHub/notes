import java.io.*;
import java.util.Arrays;

/**
 * Welcome to vivo !
 */

public class Main3 {

    private static int[][][] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] input) {
        int n = input.length;
        int sum = 0;

        for (int i : input) {
            sum += i;
        }

        int c1 = n / 2;
        int c2 = sum / 2;

        memo = new int[c1 + 1][c2 + 1][n];

        for (int[][] ints : memo) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }

        int v = f(input, c1, c2, n - 1);

        return Math.abs(sum - v * 2);
    }

    private static int f(int[] nums, int c1, int c2, int index) {
        if (c1 <= 0 || c2 <= 0 || index < 0)
            return 0;

        if (memo[c1][c2][index] != -1)
            return memo[c1][c2][index];

        int res = f(nums, c1, c2, index - 1);
        if (c2 >= nums[index])
            res = Math.max(res, f(nums, c1 - 1, c2 - nums[index], index - 1) + nums[index]);

        memo[c1][c2][index] = res;

        return res;
    }
}