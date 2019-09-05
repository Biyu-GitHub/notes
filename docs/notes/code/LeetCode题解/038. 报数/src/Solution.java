class Solution {

    public static String countAndSay(int n) {

        String s = "1";


        for (int i = 1; i < n; i++) {
            String temp = "";

            for (int j = 0; j < s.length(); j++) {
                int count = 1;
                while (j + 1 < s.length() && s.charAt(j + 1) == s.charAt(j)) {
                    count++;
                    j++;
                }
                temp = temp + count + s.charAt(j);
            }
            s = temp;
        }
        return s;
    }
}