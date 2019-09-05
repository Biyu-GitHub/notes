class Solution {

    private boolean[][] memo;

    public boolean exist(char[][] board, String word) {
        int i = 0, m = board.length;
        int j = 0, n = board[0].length;

        memo = new boolean[m][n];

        int index = 0;
        char c = word.charAt(index);

        boolean isFound = false;

        for (; i < m; i++) {
            for (; j < n; j++) {
                if (board[i][j] == c) {
                    isFound = true;
                    break;
                }
            }
            if (isFound)
                break;
        }
        return exist(board, word, 0, i, j, m, n);
    }

    private boolean exist(char[][] board, String word, int index, int i, int j, int m, int n) {
        if (index > word.length()) return true;

        char c = word.charAt(index);

        if (i < 0 || i >= m || j < 0 || j >= n || memo[i][j] || board[i][j] != c) return false;
        memo[i][j] = true;

        return exist(board, word, index + 1, i - 1, j, m, n)
                || exist(board, word, index + 1, i + 1, j, m, n)
                || exist(board, word, index + 1, i, j - 1, m, n)
                || exist(board, word, index + 1, i, j + 1, m, n);
    }
}