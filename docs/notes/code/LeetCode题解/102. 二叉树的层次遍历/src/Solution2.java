import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return res;

        levelOrder(root, 0);

        return res;
    }

    private void levelOrder(TreeNode node, int level) {
        if (node == null)
            return;

        if (level == res.size())
            res.add(new ArrayList<>());

        res.get(level).add(node.val);
        levelOrder(node.left, level + 1);
        levelOrder(node.right, level + 1);

        return;
    }
}
