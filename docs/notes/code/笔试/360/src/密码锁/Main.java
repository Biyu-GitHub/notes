package 密码锁;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String isMima(String str) {
        char[] chars = str.toCharArray();

        if (chars[0] != chars[8])
            return "NO";
        else if (chars[1] != chars[7])
            return "NO";
        else if (chars[2] != chars[6])
            return "NO";
        else if (chars[3] != chars[5])
            return "NO";
        else
            return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[] mima = new boolean[9];
        while (sc.hasNextLine()) {
            Arrays.fill(mima, false);
            String str = sc.nextLine() + sc.nextLine() + sc.nextLine();
            System.out.println(isMima(str));
        }
    }
}
