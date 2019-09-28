import java.math.BigInteger;
import java.util.Scanner;

public class Main1 {
    private static final int mod = 9999991;

    // a^t, t!
    public static int laggerInteger(int a, int t) {
        int tt = 1;
        for (int i = 2; i <= t; i++) {
            tt *= i;
        }

        return Math.max(tt, (int) Math.pow(a, t)) % mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int t = sc.nextInt();
            System.out.println(laggerInteger(a, t));
        }
    }
}
