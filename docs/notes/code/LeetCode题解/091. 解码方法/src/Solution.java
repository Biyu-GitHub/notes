class Solution {
    public static int numDecodings(String s) {

        if (s.length() == 1) {
            if (s.equals("0"))
                return 0;
            else
                return 1;
        }

        int[] memo = new int[s.length() + 1];
        memo[0] = 1;
        memo[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0')
                memo[i] += memo[i - 1];

            int num = Integer.valueOf(s.substring(i - 2, i));
            if (num > 10 && num <= 26)
                memo[i] += memo[i - 2];
        }
        return memo[memo.length - 1];
    }

    public static void main(String[] args) {
        numDecodings("10");
    }
}