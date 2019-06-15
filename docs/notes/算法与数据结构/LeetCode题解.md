## 四、栈，队列，和优先队列

### 020. Valid Parenthesesentheses

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{' || c == '[' || c == '(')
                stack.push(c);

            else {
                if (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    char tc;
                    if (c == '}')
                        tc = '{';
                    else if (c == ']')
                        tc = '[';
                    else
                        tc = '(';

                    if (tc != pop)
                        return false;
                } else
                    return false;
            }
        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
```

### 150. Evaluate Reverse Polish Notation

```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int a, b;

        for (String s : tokens) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }
}
```

