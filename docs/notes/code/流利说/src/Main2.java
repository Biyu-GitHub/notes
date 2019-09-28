import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    public static int catMove(ArrayList<String[]> list, int i, int j, int m, int n, int sum) {

        if (i < 0 || i >= m || j < 0 || j >= m)
            return 0;

        if (list.get(i)[j].equals("3"))
            return sum;

        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String[]> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            list.add(sc.nextLine().split(" "));
        }

        int m = list.size();
        int n = list.get(0).length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (list.get(i)[j].equals("2")) {
                    catMove(list, i, j, m, n, 0);
                }
            }
        }
        System.out.println(2);
    }
}
