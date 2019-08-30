# 玩转数据结构之AVL树

我们可以基于二分搜索树修改来得到AVL树

# 1 构造函数

* **平衡二叉树：**对于任意节点，左子树和右子树的高度差不能超过1
* **平衡因子：**我们需要再**二分搜索树**中记录节点高度并计算平衡因子

```java
public class AVLTree<K extends Comparable<K>, V> {
    // 节点定义，添加了节点的高度
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    // 属性
    private Node root;
    private int size;

    // 构造函数
    public AVLTree() {
        root = null;
        size = 0;
    }
}
```

# 2 基本方法

```java
public int getSize() {
    return size;
}

public boolean isEmpty() {
    return size == 0;
}

// 获得节点node的高度
private int getHeight(Node node) {
    if (node == null)
        return 0;
    return node.height;
}
```

# 3 平衡因子

* 平衡因子 = 左子树的高度 - 右子树的高度

```java
private int getBalanceFactor(Node node) {
    if (node == null)
        return 0;
    return getHeight(node.left) - getHeight(node.right);
}
```

# 4 查找方法

```java
// 返回以node为根节点的二分搜索树中，key所在的节点
private Node getNode(Node node, K key) {
    if (node == null)
        return null;

    if (key.compareTo(node.key) < 0)
        return getNode(node.left, key);
    else if (key.compareTo(node.key) > 0)
        return getNode(node.right, key);
    else
        return node;
}

public boolean contains(K key) {
    return getNode(root, key) != null;
}
```

```java
public V get(K key) {
    Node node = getNode(root, key);
    return node == null ? null : node.value;
}

public void set(K key, V newValue) {
    Node node = getNode(root, key);
    if (node == null)
        throw new IllegalArgumentException(key + " doesn't exist!");

    node.value = newValue;
}
```

```java
private Node minimum(Node node) {
    if (node.left == null)
        return node;
    return minimum(node.left);
}
```

# 5 删除节点

* 与二分搜索树的操作相同

```java
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

public V remove(K key) {
    Node node = getNode(root, key);
    if (node == null)
        return null;
    root = remove(root, key);
    return node.value;
}

private Node remove(Node node, K key) {
    if (node == null)
        return null;

    if (key.compareTo(node.key) < 0) {
        node.left = remove(node.left, key);
        return node;
    } else if (key.compareTo(node.key) > 0) {
        node.right = remove(node.right, key);
        return node;
    } else {
        if (node.left == null) {
            Node rightNode = node.right;
            size--;
            node.right = null;
            return rightNode;
        }

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        Node successor = minimum(node.right);
        successor.left = node.left;
        successor.right = removeMin(node.right);
        node.left = node.right = null;
        size--;
        return successor;
    }
}
```

# 6 判断BST

