public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val);
        sb.append(",");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    int index = -1;

    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        return deserialize(s);
    }

    private TreeNode deserialize(String[] s) {
        index++;
        if (index >= s.length || s[index].equals("#")) return null;

        TreeNode root = new TreeNode(Integer.valueOf(s[index]));
        System.out.println(root.val);
        root.left = deserialize(s);
        root.right = deserialize(s);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        root.left = n2;
        root.right = n3;

        n3.left = n4;
        n3.right = n5;

        Codec cc = new Codec();
        System.out.println(cc.serialize(root));

        cc.deserialize(cc.serialize(root));
    }
}