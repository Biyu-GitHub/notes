public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return isSubtree(root1, root2);
    }

    private boolean isSubtree(TreeNode node1, TreeNode node2) {
        if (node1 == null)
            return false;

        boolean res = false;

        if (node1.val == node2.val)
            res = subTree(node1, node2);

        if (res == true)
            return true;

        return isSubtree(node1.left, node2) || isSubtree(node1.right, node2);

    }

    private boolean subTree(TreeNode node1, TreeNode node2) {
        if (node2 == null) return true;
        if (node1 == null) return false;

        if (node1.val != node2.val) return false;

        return subTree(node1.left, node2.left) && subTree(node1.right, node2.right);
    }
}