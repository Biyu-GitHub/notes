import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    private class Inorder {
        TreeNode node;
        String msg;

        public Inorder(TreeNode node, String msg) {
            this.node = node;
            this.msg = msg;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Stack<Inorder> stack = new Stack<>();

        stack.push(new Inorder(root, "go"));

        while (!stack.isEmpty()) {
            Inorder pop = stack.pop();

            if (pop.msg.equals("visit"))
                list.add(pop.node.val);
            else {
                if (pop.node.right != null)
                    stack.push(new Inorder(pop.node.right, "go"));

                stack.push(new Inorder(pop.node, "visit"));

                if (pop.node.left != null)
                    stack.push(new Inorder(pop.node.left, "go"));
            }
        }
        return list;
    }
}
