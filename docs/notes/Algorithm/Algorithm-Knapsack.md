# 01背包问题-每个物品只有一个

## 问题描述

考虑将n个物品放入到容积为C的背包中，使得背包中的物品的价值最大。每个物品i，对应它的价值vi，以及所占的空间wi

背包的容量为5，物品的价值和所占的容积如下表：

| id     | 0    | 1    | 2    |
| ------ | ---- | ---- | ---- |
| weight | 1    | 2    | 3    |
| value  | 6    | 10   | 12   |

## 转移方程

```latex
F(i, C) = F(i - 1, C)
		  v(i) + F(i - 1, C - w(i))
```

## 自顶向下

```java
import java.util.Arrays;

public class Knapsack01 {
    private int[][] memo;

    /**
     * @param w     物品所占的空间
     * @param v     物品的价值
     * @param index 物品的id
     * @param C     背包的容积
     * @return
     */
    private int bestValue(int[] w, int[] v, int index, int C) {

        if (index < 0 || C <= 0)
            return 0;

        if (memo[index][C] != -1)
            return memo[index][C];

        int res = bestValue(w, v, index - 1, C);

        if (C - w[index] >= 0)
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, C - w[index]));

        memo[index][C] = res;

        return res;
    }

    public int knapsasck01(int[] w, int[] v, int C) {
        int n = w.length;

        memo = new int[n][C + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return bestValue(w, v, n - 1, C);
    }
}
```

## 自底向上

| w    | v    | i    | 0    | 1    | 2    | 3    | 4    | 5    |
| ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 1    | 6    | 0    | 0    | 6    | 6    | 6    | 6    | 6    |
| 2    | 10   | 1    | 0    | 6    | 10   | 16   | 16   | 16   |
| 3    | 12   | 2    | 0    | 6    | 10   | 16   | 18   | 22   |

```java
public class Knapsack01 {

    public int knapsack(int[] w, int[] v, int c) {

        assert w.length == v.length;

        int n = w.length;

        int[][] memo = new int[n][c + 1];

        // 初始化第一行，如果能放进去，则价值就为第一个物品的价值
        for (int j = 0; j <= c; j++)
            memo[0][j] = j >= w[0] ? v[0] : 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                memo[i][j] = memo[i - 1][j];
                if (j >= w[i])
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
            }
        }
        return memo[n - 1][c];
    }
}
```

## 自底向上的空间优化

* 我们发现新的一行只与上一行的状态有关，所以，我们只需要初始化一个2行的memo数组即可，对应的再程序里的memo[i] --> memo[i % 2]，即可，memo[i - 1]同理。这样的优化使得我们可以处理物品数量更多的情况。
* 另外我们发现，新的

# 完全背包问题-每个物品可以无限使用

