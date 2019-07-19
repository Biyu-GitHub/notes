public class Solution {
    String Serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }


    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("# ");
            return;
        }
        sb.append(node.val);
        sb.append(" ");

        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }


    TreeNode Deserialize(String str) {
        if (str.length() == 0) return null;
        String[] nodes = str.split(" ");
        return retree(nodes, 0);
    }

    private TreeNode retree(String[] nodes, int index) {
        if (nodes[index].equals("#") || index >= nodes.length) return null;

        TreeNode root = new TreeNode(Integer.valueOf(nodes[index]));
        root.left = retree(nodes, ++index);
        root.right = retree(nodes, ++index);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;

        Solution s = new Solution();
        String serialize = s.Serialize(root);
        System.out.println(serialize);

        String[] split = serialize.split(" ");
        System.out.println(split.length);

        s.Deserialize(serialize);
    }
}
