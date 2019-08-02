public class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        while (l < r) {
            while (l < r && !isVowels(chars[l])) l++;
            while (l < r && !isVowels(chars[r])) r--;
            char temp = chars[r];
            chars[r] = chars[l];
            chars[l] = temp;
            l++;
            r--;
        }
        return String.valueOf(chars);
    }

    private boolean isVowels(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        return false;
    }
}
