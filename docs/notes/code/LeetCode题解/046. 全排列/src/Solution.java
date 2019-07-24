import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<Integer>> ret;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        ret = new ArrayList<>();

        if (nums.length == 0) return ret;

        used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        permute(nums, 0, list);

        return ret;
    }

    private void permute(int[] nums, int index, List<Integer> list) {
        System.out.println("index:" + index);
        if (index == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                System.out.println("index:" + index + " num:" + nums[i]);
                used[i] = true;
                list.add(nums[i]);

                permute(nums, index + 1, list);

                Integer remove = list.remove(index);
                System.out.println("remove:" + remove);

                used[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ret = s.permute(new int[]{1, 2, 3});

        for (List<Integer> list : ret) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}