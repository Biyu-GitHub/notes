import java.util.ArrayList;
import java.util.Arrays;

public class Merge implements Sort {
    @Override
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r)
            return;

        int m = l + (r - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        merge(nums, l, m, r);
    }


    private void merge(int[] nums, int l, int m, int r) {
        int[] aux = new int[nums.length];
        System.arraycopy(nums, l, aux, l, r - l + 1);

        int i = l;
        int j = m + 1;

        for (int k = l; k <= r; k++) {
            if (i > m) nums[k] = aux[j++];
            else if (j <= m) nums[k] = aux[i++];
            else if (aux[i] <= aux[j]) nums[k] = aux[i++];
            else nums[k] = aux[j++];
        }
    }

    public static void main(String[] args) {
        System.arraycopy();
    }
}
