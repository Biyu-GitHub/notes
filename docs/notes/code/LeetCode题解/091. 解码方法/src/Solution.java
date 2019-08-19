class Solution {
    /**
     * 不会
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        return decodingNum(s);
    }

    private int decodingNum(String s) {
        if (s == null && s.length() == 0 || s.equals("0"))
            return 0;

        if (s.length() == 1)
            return 1;

        if (s.length() == 2)
            if (Integer.valueOf(s) <= 26)
                return 2;
            else
                return 1;

        return decodingNum(s.substring(1)) + decodingNum(s.substring(2));
    }
}