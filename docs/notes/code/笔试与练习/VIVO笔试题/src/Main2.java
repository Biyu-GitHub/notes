import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    public static void sayNumber(int n, int m) {
        int[] nums = new int[n + 1];
        ArrayList<Integer> list = new ArrayList<>(n);

        int i = 1;
        int count = 1;

        while (true) {
            if (nums[i] != 0) {
                i++;
                if (i > n)
                    i = 1;
                continue;
            }

            if (count % m == 0) {
                list.add(i);
                nums[i] = 1;
            }
            i++;
            count++;
            if (i > n)
                i = 1;

            if (list.size() == n)
                break;
        }

        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j));
            if (j != n - 1)
                System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sayNumber(n, m);
        }
    }
}