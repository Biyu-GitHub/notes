class Solution {
    int ret = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        high(root);
        return ret;
    }

    private int high(TreeNode node) {
        if (node == null)
            return 0;

        int l = high(node.left);
        int r = high(node.right);
        ret = Math.max((l + r), ret);
        return Math.max(l, r) + 1;
    }
}