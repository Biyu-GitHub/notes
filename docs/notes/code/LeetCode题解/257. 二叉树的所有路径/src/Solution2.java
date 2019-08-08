import java.util.ArrayList;
import java.util.List;

class Solution2 {
    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();

        if (root == null) return res;
        binaryTreePaths(root, "");
        return res;
    }

    private void binaryTreePaths(TreeNode node, String path) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            path += node.val;
            res.add(path);
        }
        path += "->";
        binaryTreePaths(node.left, path);
        binaryTreePaths(node.right, path);
    }
}