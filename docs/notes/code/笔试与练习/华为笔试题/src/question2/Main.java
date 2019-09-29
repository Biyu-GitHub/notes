package question2;

import java.util.Scanner;

public class Main {

    public static String reverse(String s) {
        s = s.toLowerCase();
        char[] output = s.toCharArray();
        for (int i = 0; i < output.length; i++) {
            if (output[i] == ' ')
                output[i] = '0';
        }
        StringBuilder sb = new StringBuilder(new String(output));
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(reverse(s));
        }
    }
}
