package question1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static long[] memo;

    public static long jieCheng(int n) {
        if (n == 1)
            return 1;

        if (memo[n] != -1)
            return memo[n];

        long res = n * jieCheng(n - 1);
        memo[n] = res;
        return res;
    }

    public static char f(long i) {
        char[] chars = String.valueOf(i).toCharArray();
        for (int j = chars.length - 1; j >= 0; j--) {
            if (chars[j] != '0')
                return chars[j];
        }
        return '0';
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            memo = new long[n + 1];
            Arrays.fill(memo, -1);

            long i = jieCheng(n);
            System.out.println(f(i));
        }
    }
}
