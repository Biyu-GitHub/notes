import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            int[] one = new int[n];
            int[] two = new int[n];

            Map<Integer, Integer> map = new HashMap<>(n);

            for (int i = 0; i < n; i++) {
                int c = sc.nextInt();
                int d = sc.nextInt();

                one[i] = c;
                two[i] = d;

                map.put(i, Math.abs(c - d));
            }

            ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));

            int sum1 = 0;
            int i = 0;
            for (int j = 0; j < a; j++) {
                sum1 += one[list.get(i++).getKey()];
            }
            for (int j = 0; j < b; j++) {
                sum1 += two[list.get(i++).getKey()];
            }

            int sum2 = 0;
            i = 0;
            for (int j = 0; j < b; j++) {
                sum2 += two[list.get(i++).getKey()];
            }
            for (int j = 0; j < a; j++) {
                sum2 += one[list.get(i++).getKey()];
            }

            System.out.println(Math.min(sum1, sum2));
        }
    }
}
