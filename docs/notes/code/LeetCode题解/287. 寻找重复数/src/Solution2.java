import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] < 0)
                return nums[i];
            nums[nums[i]] *= -1;
        }
        return 0;
    }
}