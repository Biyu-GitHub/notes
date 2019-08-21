import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return res;

        levelOrder(root, 0);

        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> integers : res) {
            list.add(0, integers);
        }

        return list;
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