package question1;

public class Main {


    public static int coffee(int[] nums, int k, int m) {

        int ret = m;

        if (m == 0)
            return 30 / (k + 1);

        int[] aux = new int[m + 2];
        aux[0] = 0;
        aux[m + 2 - 1] = 31;
        for (int i = 0; i < m; i++) {
            aux[i + 1] = nums[i];
        }

        for (int i = 0; i <= m; i++) {
            int v1 = aux[i];
            int v2 = aux[i + 1];

            for (int j = v1; j + k + 1 < v2; j = j + k + 1)
                ret++;
        }

        return ret;
    }

    public static void main(String[] args) {
        int K1 = 0;
        int M1 = 10;
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(coffee(nums1, K1, M1));

        int K2 = 1;
        int M2 = 15;
        int[] nums2 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29};
        System.out.println(coffee(nums2, K2, M2));

        int K3 = 1;
        int M3 = 7;
        int[] nums3 = {5, 9, 13, 17, 21, 25, 29};
        System.out.println(coffee(nums3, K3, M3));

        int K4 = 1;
        int M4 = 0;
        int[] nums4 = {};
        System.out.println(coffee(nums4, K4, M4));
    }
}
