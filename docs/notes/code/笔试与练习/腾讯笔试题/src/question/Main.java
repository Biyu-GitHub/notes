package question;

import java.util.Scanner;

public class Main {

    public static String isPhoneNumber(int n, String s) {
        if (n < 11)
            return "NO";

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '8')
                return n - i >= 11 ? "YES" : "NO";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = Integer.valueOf(sc.nextLine());

        for (int i = 0; i < k; i++) {
            int n = Integer.valueOf(sc.nextLine());
            String s = sc.nextLine();
            System.out.println(isPhoneNumber(n, s));
        }
    }
}
