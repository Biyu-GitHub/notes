import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = -1, ret = 0, n = s.length();

        while (l < n) {
            if (r + 1 < n && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(++r));
                ret = Math.max(ret, set.size());
            } else {
                set.remove(s.charAt(l++));
            }
        }
        return ret;
    }
}
