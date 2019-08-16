class Solution {
    public int surfaceArea(int[][] grid) {
        int ret = 0;

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int g = grid[i][j];

                if (g > 0) ret += 2;

                if (i - 1 >= 0) {
                    if (grid[i][j] > grid[i - 1][j])
                        ret += grid[i][j] - grid[i - 1][j];
                } else
                    ret += grid[i][j];

                if (i + 1 < n) {
                    if (grid[i][j] > grid[i + 1][j])
                        ret += grid[i][j] - grid[i + 1][j];
                } else
                    ret += grid[i][j];

                if (j - 1 >= 0) {
                    if (grid[i][j] > grid[i][j - 1])
                        ret += grid[i][j] - grid[i][j - 1];
                } else
                    ret += grid[i][j];

                if (j + 1 < m) {
                    if (grid[i][j] > grid[i][j + 1])
                        ret += grid[i][j] - grid[i][j + 1];
                } else
                    ret += grid[i][j];
            }
        }

        return ret;
    }
}