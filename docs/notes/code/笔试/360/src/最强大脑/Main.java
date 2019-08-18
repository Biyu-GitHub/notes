package 最强大脑;

import java.util.Scanner;

public class Main {
    public static void isSubString(String s, String p, String q) {
        boolean isForward = false;
        boolean isBackward = false;

        String regex = "[\\w]*" + p + "[\\w]*" + q + "[\\w]*";

        if (s.matches(regex))
            isForward = true;

        if (new StringBuilder(s).reverse().toString().matches(regex))
            isBackward = true;

        if (isForward) {
            if (isBackward)
                System.out.println("both");
            else
                System.out.println("forward");
        } else {
            if (isBackward)
                System.out.println("backward");
            else
                System.out.println("invalid");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String p = sc.nextLine();
            String q = sc.nextLine();
            isSubString(s, p, q);
        }
    }
}
