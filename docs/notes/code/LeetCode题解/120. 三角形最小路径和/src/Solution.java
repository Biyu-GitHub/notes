import java.util.Arrays;
import java.util.List;

class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] memo = new int[n];
        memo[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                int t = triangle.get(i).get(j);

                if (j == 0)
                    memo[j] += t;
                else if (j == i)
                    memo[j] = memo[j - 1] + t;
                else
                    memo[j] = Math.min(memo[j], memo[j - 1]) + t;

                System.out.print(memo[j] + " ");
            }
            System.out.println();
        }

        Arrays.sort(memo);
        return memo[n - 1];
    }
}