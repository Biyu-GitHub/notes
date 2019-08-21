public class BSTReview1<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BSTReview1() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    private void add(Node node, E e) {
        if (e.compareTo(node.e) == 0)
            return;

        if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0)
            add(node.left, e);

        if (e.compareTo(node.e) > 0)
            add(node.right.e);
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    public E minmum() {
        if (size == 0)
            throw new IllegalArgumentException();

        return minmum(root).e;
    }

    private Node minmum(Node node) {
        if (node.left == null)
            return node;

        return minmum(node.left);
    }

    public E removeMin() {
        E ret = minmum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (e.compareTo(node.e) < 0)
            return remove(node.left, e);
        else if (e.compareTo(node.e) > 0)
            return remove(node.right, e);
        else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minmum(node.right);
            successor.left = node.left;
            successor.right = removeMin(node.right);
            node.left = node.right = null;

            return successor;
        }
    }
}
