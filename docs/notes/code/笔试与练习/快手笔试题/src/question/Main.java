package question;

import java.util.Scanner;

public class Main {

    public static String isIP(String s) {

        // 先判断是不是点分的
        if (s.split("\\.").length > 1) {
            String[] ss = s.split("\\.");
            for (String i : ss) {

                if (Integer.valueOf(i) > 255 || Integer.valueOf(i) < 0)
                    return "Neither";

                if (Integer.valueOf(i) == 0 && i.length() > 1)
                    return "Neither";

                if (i.startsWith("0") && Integer.valueOf(i) != 0)
                    return "Neither";
            }
            return "IPv4";
        } else {
            String[] ss = s.split("\\:");

            for (String s1 : ss) {
                if (s1.equals("") || s1.length() > 4)
                    return "Neither";
            }
            return "IPv6";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            System.out.println(isIP(sc.nextLine()));
        }
    }
}
