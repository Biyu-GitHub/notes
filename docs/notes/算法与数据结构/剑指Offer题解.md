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

