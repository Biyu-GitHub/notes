# 快速排序

# 1 快速排序的基本代码实现
## 1.1 partition()

- 对 arr[l, r] 部分进行操作：
  - 使用第一个元素作为切分元素，即v = arr[l]；
  - 使用j指向列表的切分点，初始化j=l代表当前没有元素；
  - 使用i指向当前遍历的元素；
  - 遍历结束后没交换l与j的值，并返回j，即p。
  - 返回p，使得 arr[l, p - 1] < arr[p]; arr[p + 1, r] > arr[p]
```java
private int partition(int[] arr, int l, int r) {
    int v = arr[l];
    int j = l;
    for (int i = l + 1; i <= r; i++) {
        if (arr[i] < v) {
            swap(arr, i, j + 1);
            j++;
        }
    }
    swap(arr, l, j);
    return j;
}
```
## 1.2 quickSort
```java
public class QuickSort implements Sort {

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return;

        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }
}
```
# 2 快速排序的优化
## 2.1 随机优化

- 当数组长度小于某一个值的时候，使用插入排序来优化
- 当数组有序的时候，快排会退化成O(n)的复杂度：
  - 解决办法：随机选择切分元素，可用数学方法证明，此时，复杂度的期望是O(nlogn)的。
  - 在每次排序的时候随机选择在 [l, r]之间的元素，与l交换，再进行partition操作。
- 优化后的代码：
```java
private int partition(int[] arr, int l, int r) {
    
    // 随机选择切分元素
    ArrayUtil.swap(arr, l, random.nextInt(r - l + 1) + l);

    int v = arr[l];
    int j = l;
    for (int i = l + 1; i <= r; i++) {
        if (arr[i] < v) {
            ArrayUtil.swap(arr, i, j + 1);
            j++;
        }
    }
    ArrayUtil.swap(arr, l, j);
    return j;
}
```
## 2.2 partition()优化

- 当数组中有大量重复元素的时候，还是有问题，所以此时我们需要优化partition；
- 从数组的两端往中间进行扫描，然后交换元素
```java
private int partition2(int[] arr, int l, int r) {
    ArrayUtil.swap(arr, l, random.nextInt(r - l + 1) + l);
    int v = arr[l];

    int i = l + 1;
    int j = r;

    while (true) {
        while (i <= r && arr[i] < v) i++;
        while (j >= l + 1 && arr[j] > v) j--;

        if (i > j)
            break;

        ArrayUtil.swap(arr, i, j);
        i++;
        j--;
    }
    ArrayUtil.swap(arr, l, j);
    return j;
}
```
# 3 三路快排

- 一种处理包含有大量重复元素的更优的解法

