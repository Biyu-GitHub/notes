import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    private static final String GO = "GO";
    private static final String VISIT = "VISIT";

    private class Traver {
        TreeNode node;
        String msg;

        public Traver(TreeNode node, String msg) {
            this.node = node;
            this.msg = msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<Traver> stack = new Stack<>();
        stack.push(new Traver(root, GO));

        while (!stack.isEmpty()) {
            Traver pop = stack.pop();
            if (pop.msg.equals(VISIT)) {
                list.add(pop.node.val);
            } else {
                pop.setMsg(VISIT);
                stack.push(pop);
                if (pop.node.right != null) {
                    stack.push(new Traver(pop.node.right, GO));
                }
                if (pop.node.left != null) {
                    stack.push(new Traver(pop.node.left, GO));
                }
            }
        }
        return list;
    }
}