public class Test {
    public static void main(String[] args) {
        Sort sort = new InsertionSort();
        int[] arr = ArrayUtil.newArray(100);
        sort.sort(arr);
        ArrayUtil.show(arr);
        ArrayUtil.check(arr);
    }
}
