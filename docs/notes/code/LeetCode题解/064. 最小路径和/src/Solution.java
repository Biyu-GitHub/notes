class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        if (m == 0) return 0;

        for (int j = 1; j < m; j++)
            grid[0][j] += grid[0][j - 1];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0)
                    grid[i][j] += grid[i - 1][j];
                else
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[n - 1][m - 1];
    }
}