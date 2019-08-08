package 瞌睡;

import javax.crypto.spec.PSource;
import java.util.Scanner;

public class Main {
    public static int wakeUp(int n, int m, int[] like, boolean[] wake) {
        int l = 0, r = 0, sum = 0, ret = 0;

        while (wake[l]) l++;

        for (r = l; r < l + m && r < n; r++) {
            if (!wake[r])
                sum += like[r];
        }
        r--;
        ret = sum;
        while (l < n) {
            if (r + 1 < n) {
                if (!wake[r + 1])
                    sum += like[r + 1];
                r++;
            }
            if (!wake[l])
                sum -= like[l];
            l++;
            ret = Math.max(ret, sum);
        }
        return ret;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int maxRet = 0;
//
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//
//        int[] like = new int[n];
//        boolean[] wake = new boolean[n];
//
//        for (int i = 0; i < n; i++) {
//            like[i] = sc.nextInt();
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (sc.nextInt() == 1) {
//                wake[i] = true;
//                maxRet += like[i];
//            }
//        }
//        sc.close();

        int n = 10;
        int m = 5;
        int[] like = {6481, 6127, 4477, 5436, 7356, 3137, 1076, 7182, 8147, 835};
        boolean[] wake = {true, false, true, false, true, true, false, false, false, true};

        int maxRet = 0;

        for (int i = 0; i < n; i++) {
            if (wake[i])
                maxRet += like[i];
        }

        System.out.println(maxRet);

        System.out.println(Main.wakeUp(n, m, like, wake) + maxRet);
        /**
         * 10 5
         * 6481 6127 4477 5436 7356 3137 1076 7182 8147 835
         * 1    0    1    0     1   1     0     0   0   1
         */
    }
}

