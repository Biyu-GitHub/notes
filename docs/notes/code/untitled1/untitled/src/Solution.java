import java.util.ArrayList;

public class Solution {

    class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    private int index;

    public int findNode(Node root, int n) {
        if (root == null || n < 0)
            throw new IllegalArgumentException("");

        index = 0;

        Integer res = travel(root, n);

        if (res == null)
            throw new IllegalArgumentException("");

        return res;
    }

    private Integer travel(Node node, int n) {
        if (node == null)
            return null;

        travel(node.right, index);
        if (n == index)
            return node.val;
        index++;
        travel(node.left, index);

        return null;
    }
}
