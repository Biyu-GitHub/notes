import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();

        if (root == null)
            return res;

        ArrayList<Integer> list = new ArrayList<>();
        pathSum(root, sum, list);

        return res;
    }

    private void pathSum(TreeNode node, int sum, ArrayList<Integer> list) {
        if (node == null)
            return;

        list.add(node.val);

        if (node.val == sum && node.left == null && node.right == null) {
            res.add(new ArrayList<>(list));
        }
        pathSum(node.left, sum - node.val, list);
        pathSum(node.right, sum - node.val, list);

        list.remove(list.size() - 1);

        return;
    }
}
