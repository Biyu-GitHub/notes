import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        Arrays.sort(copy);

        int l = 0;
        int r = nums.length - 1;

        while (l < nums.length && nums[l] == copy[l]) l++;
        while (r >= 0 && nums[r] == copy[r]) r--;

        System.out.println(l);
        System.out.println(r);

        if (l != nums.length)
            return r - l + 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findUnsortedSubarray(new int[]{2, 1}));
    }
}