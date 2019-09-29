package question1;

import java.util.Scanner;

public class Main {

    public static int minNumber(int x) {
        if (x < 10)
            return x;
        int n = 1;
        while (true) {
            if (sum(n) >= x)
                return n;
            n++;
        }
    }

    private static int sum(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int ret = 0;
        for (char c : nums) {
            ret += c - '0';
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            System.out.println(minNumber(x));
        }
    }
}
