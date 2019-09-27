package 字符串全排列;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static Set<String> set;
    private static boolean[] used;

    public static void helper(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(n);
        used = new boolean[n];

        helper(s.toCharArray(),  0, sb);
    }

    private static void helper(char[] s, int index, StringBuilder sb) {
        if (index == s.length) {
            String ss = sb.toString();
            if (!set.contains(ss))
                System.out.println(ss);
            return;
        }

        for (int i = 0; i < s.length; i++) {
            if (!used[i]) {
                used[i] = true;
                sb.append(s[i]);
                helper(s, index + 1, sb);
                sb.deleteCharAt(index);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int n = Integer.valueOf(sc.nextLine());
            set = new HashSet<>(n);
            String s = "";
            for (int i = 0; i < n; i++) {
                s = sc.nextLine();
                set.add(s);
            }
            helper(s);
        }
    }
}
