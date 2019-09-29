import java.util.Arrays;

/**
 * 递归
 */
class Solution2 {

    private int[] memo;

    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return numDecodings(s, s.length() - 1);
    }

    // k代表使用的是第几个字符
    private int numDecodings(String s, int k) {

        if (k < 0)
            return 1;

        if (k == 0) {
            if (s.charAt(0) == '0') return 0;
            else return 1;
        }

        if (memo[k] != -1)
            return memo[k];

        int res = 0;

        if (s.charAt(k) != '0')
            res += numDecodings(s, k - 1);

        int v = Integer.valueOf(s.substring(k - 1, k + 1));
        if (v >= 10 && v <= 26)
            res += numDecodings(s, k - 2);

        memo[k] = res;

        return res;
    }
}