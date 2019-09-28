package question3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();

            int min = Integer.valueOf(s.replaceAll("\\?", "0"));

            int max = Integer.valueOf(s.replaceAll("\\?", "9"));

            int n = 5;

            while (n < min)
                n += 13;

            int res = 0;

            int mod = (int) Math.pow(10.0, 9.0) + 7;

            while (n <= max) {
                res = (res + 1) % mod;
                System.out.println(n + ": " + res);
                n += 13;
            }
            System.out.println(res);
        }
    }
}
