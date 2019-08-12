import java.util.ArrayList;
import java.util.List;

class Solution {

    private String[] phone = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    private List<String> list;

    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return list;

        StringBuilder sb = new StringBuilder();

        letterCombinations(digits, 0, sb);

        return list;
    }

    private void letterCombinations(String digitis, int index, StringBuilder sb) {
        if (index >= digitis.length()) {
            list.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        String s = phone[digitis.charAt(index) - '0'];

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            letterCombinations(digitis, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }

}