import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static int allNumberLessN(long[] nums, int n) {
        int res = 0;
        Arrays.sort(nums);
        while (nums[n - 1] >= n) {
            res++;
            nums[n - 1] -= n;
            addOne(nums, n - 1);
            insertionSort(nums, n);
        }
        return res;
    }

    public static void insertionSort(long[] nums, int n) {
        for (int i = n - 1; i - 1 >= 0; i--) {
            if (nums[i] < nums[i - 1]) {
                long temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }

    public static void addOne(long[] nums, int n) {
        for (int i = 0; i < n; i++) {
            nums[i]++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long n = sc.nextLong();
            long[] nums = new long[(int) n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(allNumberLessN(nums, (int) n));
        }
    }
}
