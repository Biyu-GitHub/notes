import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution2 {
    private static final String GO = "GO";
    private static final String VISIT = "VISIT";

    private class Inorder {
        TreeNode node;
        String msg;

        public Inorder(TreeNode node, String msg) {
            this.node = node;
            this.msg = msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<Inorder> stack = new Stack<>();
        stack.push(new Inorder(root, GO));

        while (!stack.isEmpty()) {
            Inorder pop = stack.pop();
            if (pop.msg.equals(VISIT)) {
                list.add(pop.node.val);
            } else {
                if (pop.node.right != null) {
                    stack.push(new Inorder(pop.node.right, GO));
                }
                pop.setMsg(VISIT);
                stack.push(pop);
                if (pop.node.left != null) {
                    stack.push(new Inorder(pop.node.left, GO));
                }
            }
        }
        return list;
    }
}
