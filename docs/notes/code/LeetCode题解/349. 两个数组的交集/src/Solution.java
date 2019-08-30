import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int x : nums1) {
            set1.add(x);
        }

        for (int x : nums2) {
            if (set1.contains(x))
                set2.add(x);
        }

        int[] res = new int[set2.size()];
        int i = 0;
        for (Integer integer : set2) {
            res[i] = integer;
            i++;
        }
        return res;
    }
}