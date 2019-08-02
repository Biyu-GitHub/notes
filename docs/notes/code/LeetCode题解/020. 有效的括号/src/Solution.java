import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (top == '(' && c != ')') return false;
                else if (top == '{' && c != '}') return false;
                else if (top == '[' && c != ']') return false;
            }
        }
        return stack.isEmpty();
    }
}
