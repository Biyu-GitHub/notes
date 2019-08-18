public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i * rows + cols] == str[0])
                    return hasPath(matrix, rows, cols, i, j, str, 1);
            }
        }
        return false;
    }

    private boolean hasPath(char[] matrix, int rows, int cols, int i, int j, char[] str, int index) {
        i
    }
}