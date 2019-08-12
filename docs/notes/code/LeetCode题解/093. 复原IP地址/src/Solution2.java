import java.util.ArrayList;
import java.util.List;

class Solution2 {

    private List<String> list;

    public List<String> restoreIpAddresses(String s) {
        list = new ArrayList<>();

        if (s == null || s.length() < 4 || s.length() > 12)
            return list;

        ArrayList<String> ll = new ArrayList<>();

        restoreIp(s, 0, ll);

        return list;
    }

    private void restoreIp(String s, int begin, ArrayList<String> ll) {

        for (int i = begin; i <= begin + 3; i++) {
            String substring = s.substring(begin, begin + i);

            if (i == 1 && substring.equals("0"))
                continue;
            if (Integer.valueOf(substring) > 255)
                continue;

            restoreIp(s, i + 1, ll);
        }
    }

}