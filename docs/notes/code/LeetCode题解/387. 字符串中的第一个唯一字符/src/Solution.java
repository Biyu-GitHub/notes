import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return -1;

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                map.put(c, -1);
            else
                map.put(c, i);
        }

        for (Character k : map.keySet()) {
            int v = map.get(k);
            if (v != -1)
                return v;
        }
        return -1;
    }
}