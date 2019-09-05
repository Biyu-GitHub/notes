import java.util.*;

public class Solution {
    public static void maxSalary(int[] salary, int n) {
        Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        for (int key : salary) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder sb = new StringBuilder(n);
        for (Map.Entry<Integer, Integer> entry : list) {
            int key = entry.getKey();
            int val = entry.getValue();
            for (int i = 0; i < val; i++) {
                sb.append(key);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[] salary = {1, 2, 4, 3, 3, 3, 4, 2, 5, 5, 5, 5, 6, 6, 6, 7, 8, 9, 10};
        maxSalary(salary, salary.length);
    }
}
