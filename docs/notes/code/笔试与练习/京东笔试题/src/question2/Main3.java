package question2;

import java.util.*;

public class Main3 {

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

            ArrayList<Integer> bl = new ArrayList<>(boy);
            ArrayList<Integer> gl = new ArrayList<>(girl);

            if (boy.size() > girl.size()) {
                System.out.println(girl.size());
                Collections.sort(gl);
                for (int i = 0; i < gl.size(); i++) {
                    System.out.print(gl.get(i));
                    if (i != gl.size() - 1)
                        System.out.println(" ");
                }
            } else {
                System.out.println(boy.size());
                Collections.sort(bl);
                for (int i = 0; i < bl.size(); i++) {
                    System.out.print(bl.get(i));
                    if (i != bl.size() - 1)
                        System.out.println(" ");
                }
            }
            System.out.println();
        }
    }
}
