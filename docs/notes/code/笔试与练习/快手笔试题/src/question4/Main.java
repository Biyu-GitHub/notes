package question4;

import java.util.*;

public class Main {

    public static int maxmum(Set<Integer> set, int min, int max) {

        int res = 0;

        for (int i = 1; i < (max - min) / 2; i++) {
            int a = min;
            int temp = 1;

            while (set.contains(a + i)) {
                temp++;
                a += i;
            }
            res = Math.max(res, temp);
        }
        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {

            int n = sc.nextInt();
            Set<Integer> set = new HashSet<>(n);

            int min = Integer.MAX_VALUE;
            int max = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                min = Math.min(min, a);
                max = Math.max(max, a);
                set.add(a);
            }
            System.out.println(maxmum(set, min, max));
        }
    }
}
