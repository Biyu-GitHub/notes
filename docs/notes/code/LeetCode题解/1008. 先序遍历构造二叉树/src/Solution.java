class Solution {
    /**
     * 使用先序遍历构造二分搜索树
     * 输入：[8,5,1,7,10,12]
     * 输出：[8,5,10,1,7,null,12]
     *
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }

    private TreeNode bstFromPreorder(int[] preorder, int l, int r) {
        if (l > r)
            return null;

        TreeNode root = new TreeNode(preorder[l]);
        int index = l;

        for (l = l + 1; l <= r; l++) {
            if (preorder[l] > root.val)
                break;
        }


        root.left = bstFromPreorder(preorder, index + 1, l - 1);
        root.right = bstFromPreorder(preorder, l, r);

        return root;
    }
}
