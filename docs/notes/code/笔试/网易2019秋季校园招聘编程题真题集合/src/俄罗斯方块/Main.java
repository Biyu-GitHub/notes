package 俄罗斯方块;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 0; i < q; i++) {
            arr[sc.nextInt()]++;
        }
        sc.close();

        int ret = arr[1];
        for (int i = 2; i <= n; i++) {
            ret = Math.min(ret, arr[i]);
        }
        System.out.println(ret);
    }
}
