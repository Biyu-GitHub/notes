public class Solution {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode.right != null) {
            TreeLinkNode cur = pNode.right;
            while (cur.left != null)
                cur = cur.left;
            return cur;
        }

        if (pNode.next == null)
            return null;

        if (pNode.next.left == pNode)
            return pNode.next;


        TreeLinkNode cur = pNode.next;
        while (cur.next != null && cur.next.left != cur)
            cur = cur.next;
        return cur.next;

    }
}