package question5;

import java.util.Scanner;

public class Main {

    public static int longgestDistence(String s, int n) {
        String[] paths = s.split("F");
        int res = paths[0].length();
        for (int i = 1; i < paths.length; i++) {
            if (paths[i].length() > res)
                res = paths[i].length();
        }

        res += n;

        return res > s.length() ? s.length() : res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.valueOf(sc.nextLine());
        System.out.println(longgestDistence(s, n));
    }
}
