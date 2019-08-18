public class Solution {
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        int[] aux = new int[n + 1];
        aux[1] = 1;

        for (int i = 2; i <= n; i++) {
            aux[i] = aux[i - 1] + aux[i - 2];
        }

        return aux[n];
    }
}