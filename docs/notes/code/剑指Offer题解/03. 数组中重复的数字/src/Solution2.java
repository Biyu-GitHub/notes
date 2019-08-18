public class Solution2 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            if (i != index) {
                if (index == numbers[index]) {
                    duplication[0] = index;
                    return true;
                } else {
                    int temp = index;
                    numbers[i] = numbers[index];
                    numbers[index] = temp;
                }
            }
        }
        return false;
    }
}