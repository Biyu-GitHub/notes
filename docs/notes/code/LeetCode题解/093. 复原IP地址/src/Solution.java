import java.util.ArrayList;
        import java.util.List;

class Solution {
    private List<String> ret;

    public List<String> restoreIpAddresses(String s) {
        ret = new ArrayList<>();
        String[] list = new String[4];
        restoreIpAddresses(s, 0, 0, list);
        return ret;
    }

    /**
     * 判断截取的ip是否合法
     * @param s
     * @return
     */
    private boolean illegal(String s) {
        if (s == null || s.length() == 0)
            return false;

        if (s.startsWith("0") && s.length() > 1)
            return false;

        if (Integer.valueOf(s) < 0 || Integer.valueOf(s) > 255)
            return false;

        return true;
    }

    private void restoreIpAddresses(String s, int index, int start, String[] list) {
        if (index > 3)
            return;

        if (index == 3) {
            if (start + 3 >= s.length() && illegal(s.substring(start))) {
                list[index] = s.substring(start);
                ret.add(String.join(".", list));
                return;
            }
        }


        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            // 首先截取一段字符串，长度为1，2，3
            String sip = s.substring(start, start + len);
            if (illegal(sip)) {
                list[index] = sip;
                restoreIpAddresses(s, index + 1, start + len, list);
            }
        }
    }

    public static void main(String[] args) {
        String ip = "172162541";

        Solution s = new Solution();
        List<String> list = s.restoreIpAddresses(ip);
        for (String s1 : list) {
            System.out.println(s1);
        }
    }
}
