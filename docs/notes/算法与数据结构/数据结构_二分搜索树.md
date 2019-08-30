# 玩转数据结构之二分搜索树

# 1 构造方法
- 定义树的节点：包括数据以及左右指针
- 构造函数：初始化root为空，size为0
```java
public class BST<E extends Comparable<E>> {

    // 二叉树的节点
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    // 属性
    private Node root;
    private int size;

    // 构造函数
    public BST() {
        root = null;
        size = 0;
    }
}
```

# 2 基本方法

```java
public int size() {
    return size;
}

public boolean isEmpty() {
    return size == 0;
}
```
# 3 添加元素

* 当root为空的时候，新插入的节点为根节点
* 小的插入到左子树的叶子节点，大的插入到右子树的叶子节点

```java
public void add(E e) {
	if (root == null) {
    	root = new Node(e);
        size++;
        return;
    } else {
    	add(root, e);
    }
}

private void add(Node node, E e) {
    if (e.equals(node.e))
        return;
    else if (e.compareTo(node.e) < 0 && node.left == null) {
        node.left = new Node(e);
        size++;
        return;
    } else if (e.compareTo(node.e) > 0 && node.right == null) {
        node.right = new Node(e);
        size++;
        return;
    }

    if (e.compareTo(node.e) < 0)
        add(node.left, e);
    else
        add(node.right, e);
}
```
# 4 查询方法
## 4.1 是否包含e
```java
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
```
## 4.2 查询最小值

* 一直向左搜索即可

```java
public E minmum() {
    if (size == 0)
        throw new IllegalArgumentException("BST is empty!");
    Node minNode = minmum(root);
    return minNode.e;
}

private Node minmum(Node node) {
    if (node.left == null)
        return node;
    return minmum(node.left);
}
```
## 4.3 查询最大值

* 一直向右搜索即可

```java
public E maxmum() {
    if (size == 0)
        throw new IllegalArgumentException("BST is empty!");
    Node maxNode = maxmum(root);
    return maxNode.e;
}

private Node maxmum(Node node) {
    if (node.right == null)
        return node;
    return maxmum(node.right);
}
```
# 5 删除元素
* 从最简单的，删除最小值与最大值开始。
* 最小值的左子树一定为空，所以返回node.right即可
* 删除最大值同理

## 4.1 removeMin()
```java
public E removeMin() {
    E ret = minmum();
    root = removeMin(root);
    return ret;
}

private Node removeMin(Node node) {
	if (node.left == null) {
    	Node rightNode = node.right;
        size--;
        return rightNode;
    }
    
    node.left = removeMin(node.left);
    
    return node;
}
```
## 4.2 removeMax()
```java
public E removeMax() {
    E ret = maxmum();
    root = removeMax(root);
    return ret;
}

private Node removeMax(Node node) {
    if (node.right == null) {
        Node leftNode = node.left;
        node.left = null;
        size--;
        return leftNode;
    }

    node.right = removeMax(node.right);
    return node;
}
```
## 4.3 remove(E e)
删除任意节点需要分三种情况：

1. 该节点只有左子树：return node.left 即可
1. 该节点只有右子树：return node.right 即可
1. 该节点具有左右子树：寻找替代节点--该节点右子树中的最小值
   1. 找到右子树的最小节点；
   2. 删除右子树的最小节点
   3. 用此最小节点替换要删除的节点
```java
public void remove(E e) {
    root = remove(root, e);
}

private Node remove(Node node, E e) {
    if (node == null)
        return null;

    if (e.compareTo(node.e) < 0) {
        node.left = remove(node.left, e);
        return node;
    } else if (e.compareTo(node.e) > 0) {
        node.right = remove(node.right, e);
        return node;
    } else {
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
        successor.right = removeMin(node.right);
        successor.left = node.left;

        node.left = node.right = null;

        return successor;
    }
}
```

