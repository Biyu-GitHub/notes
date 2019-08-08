import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();

        if (root == null) return res;

        ArrayList<String> list = new ArrayList();

        binaryTreePaths(root, list);

        return res;
    }

    private void binaryTreePaths(TreeNode node, ArrayList<String> list) {

        if (node == null) return;

        list.add("" + node.val);

        if (node.left == null && node.right == null) {
            res.add(new String(String.join("->", list)));
        }

        binaryTreePaths(node.left, list);
        binaryTreePaths(node.right, list);

        list.remove(list.size() - 1);
    }
}