# 归并排序

# 1 自顶向下的归并排序
```java
/**
 * 归并排序的递归方法
 */
public class MergeSort implements Sort {

    private int[] aux;

    @Override
    public void sort(int[] arr) {
        aux = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }

    // 定义排序的区间是 [l, r] 闭区间
    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    // 归并方法
    private void merge(int[] arr, int l, int mid, int r) {

        System.arraycopy(arr, l, aux, l, r - l + 1);

        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {
            if (i > mid)
                arr[k] = aux[j++];
            else if (j > r)
                arr[k] = aux[i++];
            else if (aux[i] <= aux[j])
                arr[k] = aux[i++];
            else
                arr[k] = aux[j++];
        }
    }
}
```
# 2 自底向上的归并排序

- sz：每次要归并的数组的长度，从1开始，之后每次的长度变为原来的2倍，即sz += sz；另外sz可以等于数组的长度；
- i：代表第一个归并数组的起始位置，从0开始，每次递增2个size长度，即i += sz + sz；
- 每次归并的数组为 [i, i + sz - 1] 和 [i + sz, i +2sz - 1];
- 边界问题：
1. 确保第二个数组的起始位置不越界，即i + sz < arr.length；
1. 确保第二个数组的结束位置不越界，即每次的取值为：组长度与i + sz + sz - 1的较小的值。
```java
public class MergeSortBU implements Sort {

    @Override
    public void sort(int[] arr) {
        for (int sz = 1; sz <= arr.length; sz += sz) {
            for (int i = 0; i + sz < arr.length; i += sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(arr.length - 1, i + sz + sz - 1));
            }
        }
    }
}
```
# 3 扩展

- 自底向上的归并排序并没有使用数组的索引，所以可以将此方法用到链表上；
- 完成对链表的自底向上的归并排序。

- [ ]  [148. 排序链表](https://leetcode-cn.com/problems/sort-list/)
> 在 _O_(_n_ log _n_) 时间复杂度和常数级空间复杂度下，对链表进行排序。


