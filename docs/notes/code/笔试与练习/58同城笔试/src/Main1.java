import java.util.Scanner;

public class Main1 {

    private static char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '`', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '{', '}', '\\', '<', '>', '?'};

    public static String parse27(int n) {
        if (n < 27)
            return String.valueOf(map[n]);
        boolean flag;
        if (n < 0) {
            flag = true;
            n *= -1;
        } else
            flag = false;

        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            sb.insert(0, map[n % 27]);
            n /= 27;
        }
        if (flag)
            sb.insert(0, '-');
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(parse27(n));
        }
    }
}
