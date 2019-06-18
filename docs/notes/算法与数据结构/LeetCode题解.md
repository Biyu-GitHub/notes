## 约定

### 1. Definition for a binary tree node

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
```

## Top 100 Liked Questions

### 448. Find All Numbers Disappeared in an Array

将出现的数字的位置，标记为负数，则整数对应的位置为没有出现的数

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;

            if (nums[val] > 0)
                nums[val] = -nums[val];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                list.add(i + 1);
        }
        return list;
    }
}
```

### 001. Two Sum

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];

            if (map.containsKey(val)) {
                ret[0] = i;
                ret[1] = map.get(val);
            } else
                map.put(nums[i], i);
        }
        return ret;
    }
}
```



## 栈，队列，和优先队列

### 020. Valid Parenthesesentheses

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{' || c == '[' || c == '(')
                stack.push(c);

            else {
                if (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    char tc;
                    if (c == '}')
                        tc = '{';
                    else if (c == ']')
                        tc = '[';
                    else
                        tc = '(';

                    if (tc != pop)
                        return false;
                } else
                    return false;
            }
        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
```

### 150. Evaluate Reverse Polish Notation

```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int a, b;

        for (String s : tokens) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }
}
```

### 071. Simplify Path

```java
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] sp = path.split("/");

        for (String p : sp) {
            if (p.equals(""))
                continue;
            else if (p.equals("."))
                continue;
            else if (p.equals("..")) {
                try {
                    stack.pop();
                } catch (Exception e) {
                    continue;
                }
            } else
                stack.push(p);
        }

        if (stack.isEmpty())
            return "/";

        StringBuilder ret = new StringBuilder();
        while (!stack.isEmpty()) {
            ret.insert(0, stack.pop());
            ret.insert(0, "/");
        }
        return ret.toString();
    }
}
```

### 144. Binary Tree Preorder Traversal

#### 1. 递归写法

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    private void preorderTraversal(TreeNode node, List list) {
        if (node == null)
            return;

        list.add(node.val);
        preorderTraversal(node.left, list);
        preorderTraversal(node.right, list);
    }
}
```

#### 2. 模拟系统栈写法

可以方便的变成中序和后序，只需要改动一行代码

```java
class Solution2 {
    private class Command {
        private String s;
        private TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<Command> stack = new Stack<>();

        stack.push(new Command("go", root));

        while (!stack.isEmpty()) {
            Command pop = stack.pop();
            if (pop.s.equals("print"))
                list.add(pop.node.val);
            else {
                if (pop.node.right != null)
                    stack.push(new Command("go", pop.node.right));

                if (pop.node.left != null)
                    stack.push(new Command("go", pop.node.left));

                stack.push(new Command("print", pop.node));
            }
        }
        return list;
    }
}
```

## 二叉树和递归

### 100. Same Tree

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null)
            return q == null;
        if (q == null)
            return p == null;

        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false;
    }
}
```

### 101. Symmetric Tree

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode lNode, TreeNode rNode) {
        if (lNode == null)
            return rNode == null;
        if (rNode == null)
            return lNode == null;

        if (lNode.val == rNode.val)
            return isSymmetric(lNode.left, rNode.right) && isSymmetric(lNode.right, rNode.left);
        else
            return false;
    }
}
```

### 222. Count Complete Tree Nodes

```java
// 使用前序遍历
class Solution {
    private int ret;

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        
        ret++;
        countNodes(root.left);
        countNodes(root.right);

        return ret;
    }
}
```

