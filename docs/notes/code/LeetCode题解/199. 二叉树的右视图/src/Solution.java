import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return list;
        }
        rightSideView(root, 0);
        return list;
    }

    private void rightSideView(TreeNode node, int level) {
        if (node == null)
            return;

        if (level == list.size())
            list.add(node.val);
        else
            list.set(level, node.val);

        rightSideView(node.left, level + 1);
        rightSideView(node.right, level + 1);
    }
}