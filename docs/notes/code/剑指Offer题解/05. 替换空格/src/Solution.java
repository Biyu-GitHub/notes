public class Solution {
    public String replaceSpace(StringBuffer str) {
        int oldLength = str.length();
        int spaceNum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                spaceNum++;
        }

        int newLength = oldLength + spaceNum * 2;
        str.setLength(newLength);

        int i = oldLength - 1;
        int k = newLength - 1;

        while (i >= 0) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(k--, '0');
                str.setCharAt(k--, '2');
                str.setCharAt(k--, '%');
            } else
                str.setCharAt(k--, str.charAt(i));
            i--;
        }

        return str.toString();
    }
}