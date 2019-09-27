public class Test {

    public static void main(String[] args) {

        Sort sort = new QuickSort();

        int[] nums = ArrayUtil.newArray(20);

        sort.sort(nums);

        ArrayUtil.show(nums);
        ArrayUtil.check(nums);
    }
}
