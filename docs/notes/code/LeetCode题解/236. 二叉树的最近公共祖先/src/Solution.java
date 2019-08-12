/**
 * 执行结果 : 通过
 * 执行用时 : 980 ms, 在所有 Java 提交中击败了 5.02% 的用户
 * 内存消耗 : 38.8 MB, 在所有 Java 提交中击败了 9.37% 的用户
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root.val == p.val || root.val == q.val)
            return root;

        if ((contains(root.left, p) && contains(root.right, q)) || (contains(root.left, q) && contains(root.right, p)))
            return root;
        else if (contains(root.left, p) && contains(root.left, q))
            return lowestCommonAncestor(root.left, p, q);
        else
            return lowestCommonAncestor(root.right, p, q);

    }

    private boolean contains(TreeNode root, TreeNode node) {
        if (root == null)
            return false;

        if (root.val == node.val)
            return true;
        else
            return contains(root.left, node) || contains(root.right, node);
    }

}
