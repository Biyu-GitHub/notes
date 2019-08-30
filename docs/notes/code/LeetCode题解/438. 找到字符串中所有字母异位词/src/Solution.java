import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (s == null || s.length() < p.length())
            return res;

        int[] ss = new int[26];
        int[] pp = new int[26];

        for (int i = 0; i < p.length(); i++) {
            ss[s.charAt(i) - 'a']++;
            pp[p.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = l + p.length() - 1;

        while (r  + 1< s.length()) {
            if (Arrays.equals(ss, pp))
                res.add(l);

            ss[s.charAt(l++) - 'a']--;
            ss[s.charAt(++r) - 'a']++;
        }
        if (Arrays.equals(ss, pp))
            res.add(l);
        return res;
    }
}