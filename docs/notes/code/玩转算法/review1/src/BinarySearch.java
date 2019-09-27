public class BinarySearch {

    public static int binarySearch(int[] nums, int v) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == v)
                return m;
            else if (nums[m] < v)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(nums,2));
    }
}
