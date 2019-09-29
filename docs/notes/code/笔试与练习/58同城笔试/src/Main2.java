import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static int tp99(int[] nums) {
        Arrays.sort(nums);

        return nums[197];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int[] nums = new int[200];

            for (int i = 0; i < 200; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(tp99(nums));
        }
    }
}
