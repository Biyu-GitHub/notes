import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {

//        String[] words = {"apple","app"};
        String[] newWords = new String[words.length];
//        String order = "abcdefghijklmnopqrstuvwxyz";
        System.arraycopy(words, 0,newWords,0, words.length);

        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int n1 = s1.length();
                int n2 = s2.length();

                for (int i = 0; i < (n1 <= n2 ? n1 : n2); i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        return map.get(s1.charAt(i)) - map.get(s2.charAt(i));
                    }
                }
                return n1 - n2;
            }
        });

        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(newWords[i])){
                return false;
            }
        }
        return true;
    }

}