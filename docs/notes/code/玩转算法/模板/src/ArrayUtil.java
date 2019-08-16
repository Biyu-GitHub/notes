import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ArrayUtil {
    private static Random rm = new Random();

    public static int[] newArray(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int j = rm.nextInt(n);

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        show(arr);
        return arr;
    }

    public static void show(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    public static void check(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                throw new RuntimeException("Array Not Sirted!");
        }

        System.out.println("Array is sorted!");
    }
}
