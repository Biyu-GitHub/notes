package question2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static String[] map = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private static ArrayList<String> list;


    public static void phoneNumber(String s) {

        list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        phoneNumber(s, 0, sb);
    }

    public static void phoneNumber(String s, int index, StringBuilder sb) {

        if (index >= s.length()) {
            list.add(sb.toString());
            return;
        }

        // 获取输入的数字对应的字母组合
        String numbers = map[s.charAt(index) - '0'];

        for (int i = 0; i < numbers.length(); i++) {
            sb.append(numbers.charAt(i));
            phoneNumber(s, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {

            // 获取输入
            String s = sc.nextLine();

            // 回溯
            phoneNumber(s);

            // 打印结果
            int n = list.size();
            System.out.print("[");
            for (int i = 0; i < n; i++) {
                System.out.print(list.get(i));
                if (i != n - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
