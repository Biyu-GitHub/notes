package question2;

import java.util.Scanner;

public class Main {

    // a < b --> a >= b, a = a + p, p = p * q
    // 1 5 7 2
    public static int minProcess(int a, int b, int p, int q) {
        int res = 0;

        while (true) {
            if (a + p >= b)
                return res + 1;
            if (p > p * q)
                a += p;
            else
                p *= q;
            res++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 4; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int p = sc.nextInt();
                int q = sc.nextInt();
                System.out.println(minProcess(a, b, p, q));
            }
        }
    }
}
