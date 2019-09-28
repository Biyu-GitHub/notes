import java.util.Random;

public class Main {

    // a = [10,12,30,14,25,64,71,81,19]
    // dp[i] = dp[i] || v[i] + dp[i - 2]

    public void randomNum(int[] nums) {
        Random random = new Random();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int j = random.nextInt(n);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {10,12,30,14,25,64,71,81,19};
        Main m = new Main();
        m.randomNum(a);
        for (int x : a) {
            System.out.println(x);
        }
    }
}
