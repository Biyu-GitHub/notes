import java.util.Scanner;

public class Main3 {

    private static char[] mask = {'M', 'A', 'S', 'K'};

    public static String emailMask(String email) {
        StringBuilder sb = new StringBuilder();

        String[] emails = email.split("@");
        String name = emails[0];

        int j = 0;
        for (int i = 0; i < name.length(); i++) {
            sb.append(name.charAt(i));
            if (j >= 4)
                j = 0;
            sb.append(mask[j++]);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append('@');
        sb.append(emails[1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String email = sc.nextLine();
            System.out.println(emailMask(email));
        }
    }
}
