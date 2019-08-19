package fibonacci;

import java.util.Arrays;

public class Fibonacci {

    public static int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return fib(n, memo);
    }

    private static int fib(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] == -1)
            memo[n] = fib(n-1, memo) + fib(n - 2, memo);

        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci.fib(40));
    }
}
