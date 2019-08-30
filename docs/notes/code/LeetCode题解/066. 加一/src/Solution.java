class Solution {
    public int[] plusOne(int[] digits) {
        int flag = 0;
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            int v = digits[i] + 1;
            flag = v / 10;
            digits[i] = v % 10;
        }
        if (flag == 0)
            return digits;

        int[] ret = new int[n + 1];
        ret[0] = flag;
        System.arraycopy(digits, 0, ret, 1, n);
        return ret;
    }
}