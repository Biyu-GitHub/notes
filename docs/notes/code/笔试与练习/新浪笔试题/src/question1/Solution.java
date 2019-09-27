package question1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 版本号排序
 * 输入：String[] list = {2.0, 2.2.1, 3.1.4}
 * 输出：最小的版本号
 */
public class Solution {
    public String getMinVersion(String[] list) {
        // 在这里编写代码
        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] s1 = o1.split("\\.");
                String[] s2 = o2.split("\\.");

                int n1 = s1.length;
                int n2 = s2.length;

                for (int i = 0; i < Math.min(n1, n2); i++) {
                    if (!s1[i].equals(s2[i])) {
                        return Integer.valueOf(s1[i]) - Integer.valueOf(s2[i]);
                    }

                }
                return n1 - n2;
            }
        });
        return list[0];
    }
}