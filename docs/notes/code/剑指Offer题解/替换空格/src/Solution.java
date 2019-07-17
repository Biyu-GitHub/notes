/**
 * 1. 计算替换后的长度
 * 2. 从后往前替换
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        int spacenum = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                spacenum++;
        }

        int oldLength = str.length();
        int newLength = oldLength + spacenum * 2;

        str.setLength(newLength);

        int p1 = oldLength - 1;
        int p2 = newLength - 1;

        while (p1 >= 0) {
            if (str.charAt(p1) != ' ') {
                str.setCharAt(p2, str.charAt(p1));
                p2--;
            } else {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            }
            p1--;
        }
        return str.toString();
    }
}