import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer a = null;
        Integer b = null;
        Integer c = null;

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                b = stack.pop();
                a = stack.pop();

                switch (token) {
                    case "+":
                        c = a + b;
                        break;
                    case "-":
                        c = a - b;
                        break;
                    case "*":
                        c = a * b;
                        break;
                    case "/":
                        c = a / b;
                        break;
                    default:
                        break;
                }
                stack.push(c);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}