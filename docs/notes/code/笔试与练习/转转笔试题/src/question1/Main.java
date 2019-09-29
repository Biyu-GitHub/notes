package question1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 字符串中不重复的字母个数
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (sc.hasNextLine()) {
            set.clear();
            String[] strings = sc.nextLine().split(",");
            for (String s : strings) {
                set.add(s);
            }
            System.out.println(set.size());
        }
    }
}
