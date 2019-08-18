import java.util.ArrayList;

public class Solution {
    public int minNumberInRotateArray(int[] array) {
        int l = 0;
        int r = array.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (array[m] > array[r])
                l = m + 1;
            else if (array[m] == array[r])
                r--;
            else
                r = m;
        }
        return array[l];
    }
}