import java.util.Objects;

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || Objects.equals("", s))
            return true;

        char[] chars = s.toLowerCase().toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {
            while (i < chars.length && !Character.isLetterOrDigit(chars[i])) i++;
            while (j < chars.length &&!Character.isLetterOrDigit(chars[j])) j--;

            if (chars[i] != chars[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}