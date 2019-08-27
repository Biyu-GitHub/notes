package question2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Set<Integer> boy = new TreeSet<>();
            Set<Integer> girl = new TreeSet<>();

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                boy.add(x);
                girl.add(y);
            }

            StringBuilder sb = new StringBuilder();
            StringBuilder sg = new StringBuilder();
            for (Integer integer : boy) {
                sb.append(integer);
            }
            for (Integer integer : girl) {
                sg.append(integer);
            }
            String sbb = String.join(" ", sb);
            String sgg = String.join(" ", sg);

            if (boy.size() > girl.size()) {
                System.out.println(girl.size());
                System.out.println(sgg);
            } else {
                System.out.println(boy.size());
                System.out.println(sbb);
            }
        }
    }
}
