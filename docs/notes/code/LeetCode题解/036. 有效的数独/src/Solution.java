import java.util.HashMap;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] hang = new HashMap[9];
        HashMap<Integer, Integer>[] lie = new HashMap[9];
        HashMap<Integer, Integer>[] kuai = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            hang[i] = new HashMap<Integer, Integer>();
            lie[i] = new HashMap<Integer, Integer>();
            kuai[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int k = (i / 3) * 3 + j / 3;
                    hang[i].put(n, hang[i].getOrDefault(n, 0) + 1);
                    lie[j].put(n, lie[j].getOrDefault(n, 0) + 1);
                    kuai[k].put(n, kuai[k].getOrDefault(n, 0) + 1);

                    if (hang[i].get(n) > 1 || lie[j].get(n) > 1 || kuai[k].get(n) > 1)
                        return false;
                }
            }
        }
        return true;
    }
}