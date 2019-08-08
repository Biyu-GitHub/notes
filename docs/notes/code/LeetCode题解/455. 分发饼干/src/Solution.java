import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = g.length - 1;
        int si = s.length - 1;
        int res = 0;

        while (si >= 0 && gi >= 0) {
            if (s[si] >= g[gi]) {
                si--;
                res++;
            }
            gi--;
        }
        return res;
    }
}