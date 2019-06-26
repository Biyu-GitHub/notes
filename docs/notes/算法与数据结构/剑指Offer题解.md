## 不用加减乘除做加法

* 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。

```java
public class Solution {
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int ret = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = ret;
        }
        return num1;
    }
}
```

## 构建乘积数组

* 给定一个数组`A[0,1,...,n-1]`,请构建一个数组`B[0,1,...,n-1]`,其中B中的元素`B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]`。不能使用除法。

```java
public class Solution {
    public int[] multiply(int[] A) {
        int[] aux = new int[A.length];
        aux[0] = 1;

        for (int i = 1; i < A.length; i++) {
            aux[i] = aux[i - 1] * A[i - 1];
        }

        int product = 1;
        for (int i = A.length - 1; i >= 0; i--) {

            int temp = A[i];
            A[i] = product * aux[i];
            product *= temp;
        }
        return A;
    }
}
```

## 求1+2+3+...+n

* 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

```java
public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n >= 1) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
```

## 两个链表的第一个公共结点

```java
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;

        while (cur1 != cur2) {
            cur1 = (cur1 == null ? pHead2 : cur1.next);
            cur2 = (cur2 == null ? pHead1 : cur2.next);
        }
        return cur1;
    }
}
```

## 旋转数组的最小数字

* 暴力解法

```java
public class Solution {
    public int minNumberInRotateArray(int[] array) {
        int n = array.length;

        if (n == 0)
            return 0;

        for (int i = 1; i < n; i++) {
            if (array[i - 1] > array[i])
                return array[i];
        }

        return array[0];
    }
}
```

## 包含min函数的栈

```java
import java.util.Stack;

public class Solution {
    // 辅助栈
    private Stack<Integer> stack;
    private Stack<Integer> aux;
	
    // 构造函数
    public Solution() {
        stack = new Stack<>();
        aux = new Stack<>();
    }
    
	/**辅助栈为空，则直接入栈；
     * 如果node小于辅助栈顶，直接入栈，
     * 否则说明辅助栈顶的元素为最小，则再次入栈辅助栈顶元素，保持两个栈长度一致，
     * 辅助栈栈栈顶元素最小
     * */
    public void push(int node) {
        stack.push(node);

        if (aux.isEmpty())
            aux.push(node);
        else {
            if (node < aux.peek())
                aux.push(node);
            else
                aux.push(aux.peek());
        }
    }

    public void pop() {
        stack.pop();
        aux.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return aux.peek();
    }
}
```

