import java.util.Scanner;

public class Main1 {

    public static Long maxLcmGcd(int n) {
        Long x = Long.valueOf(n);

        return x * (x - 1) - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(maxLcmGcd(n));
        }
    }
}
