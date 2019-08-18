import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if (stack1.isEmpty()) {
            stack1.push(node);
            return;
        }

        while (!stack1.isEmpty())
            stack2.push(stack1.pop());

        stack1.push(node);

        while (!stack2.isEmpty())
            stack1.push(stack2.pop());

    }

    public int pop() {
        if (stack1.isEmpty())
            throw new IllegalArgumentException("Empty!");
        return stack1.pop();
    }
}