import java.util.Stack;

public class Solution2 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty())
            return stack2.pop();

        while (!stack1.isEmpty())
            stack2.push(stack1.pop());

        if (stack2.isEmpty())
            throw new IllegalArgumentException("Empty!");

        return stack2.pop();
    }
}