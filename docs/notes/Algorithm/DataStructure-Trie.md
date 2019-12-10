# 玩转数据结构之前缀树

# 1 相关题目

- [ ]  [208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)
> 实现一个 Trie (前缀树)，包含 `insert`, `search`, 和 `startsWith` 这三个操作。

- [ ]  [211. 添加与搜索单词 - 数据结构设计](https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/)
> Trie与简单的模式匹配问题

- [ ]  [677. 键值映射](https://leetcode-cn.com/problems/map-sum-pairs/)
> Trie与字符串映射

# 2 基本介绍


- Trie：专门为处理字符串而设计的。
- 查询每个条目的时间复杂度和字典中一共有多少条目无关，时间复杂度为O(w)，w为查询单词的长度。
- 以字母为单位，将字符串拆开。
- 每个节点有若干指向下一个节点的指针。
- **在节点中不存储char是没有关系的。**
- 但是需要一个标识来表明当前节点是否是一个单词的结尾。
# 3 构造方法

```java
public class Trie {

    // 节点定义
    private class Node {

        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }
	
    // 属性
    private Node root;
    private int size;

    // 构造方法
    public Trie() {
        root = new Node();
        size = 0;
    }
```
# 4 插入单词

- 一个字符一个字符插入，插入结束后需要判断当前字符是否已经是一个单词的结尾，如果是，则设置 `cur.isWord = true` 并进行 `size++` 操作。
```java
public void add(String word) {
    Node cur = root;

    for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.next.get(c) == null)
            cur.next.put(c, new Node());
        cur = cur.next.get(c);
    }

    if (!cur.isWord) {
        cur.isWord = true;
        size++;
    }
}
```
# 5 查询单词

- 查询到word结尾的时候需，要判断cur指向的字符是否是一个单词的结尾。
```java
public boolean contains(String word) {
    Node cur = root;

    for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);

        if (root.next.get(c) == null)
            return false;

        cur = cur.next.get(c);
    }

    return cur.isWord;
}
```
# 6 前缀搜索

- 注意与查询单词是否存在的区别，不用判断是否是一个单词的结尾
```java
public boolean isPrefix(String prefix) {
    Node cur = root;

    for (int i = 0; i < prefix.length(); i++) {
        char c = prefix.charAt(i);

        if (cur.next.get(c) == null)
            return false;

        cur = cur.next.get(c);
    }

    return true;
}
```
# 7 删除单词

- 如果要删除的单词的结尾字符是叶子节点，则从底向上递归地删除所有next为空地节点；
- 如果不是叶子节点，则只需要将isWord设置为false即可。
# 8 Trie的局限性

- 空间问题，每个节点之存储了一个字符；
- 解决思路：
1. **压缩字典树：**将只有一个孩子的节点合并成一个节点，但是相应的插入新单词的成本更高，操作更加复杂。
1. **三分搜索树：**

