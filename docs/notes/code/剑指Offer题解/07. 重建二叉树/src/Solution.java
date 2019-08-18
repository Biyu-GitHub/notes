public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reTree(int[] pre, int pL, int pR, int[] in, int iL, int iR) {

        if (pL > pR || iL > iR)
            return null;

        TreeNode root = new TreeNode(pre[pL]);

        for (int i = iL; i <= iR; i++) {
            if (in[i] == pre[pL]) {
                root.left = reTree(pre, pL + 1, pL + i - iL, in, iL, i - 1);
                root.right = reTree(pre, pL + i - iL + 1, pR, in, i + 1, iR);

                break;
            }
        }

        return root;
    }
}