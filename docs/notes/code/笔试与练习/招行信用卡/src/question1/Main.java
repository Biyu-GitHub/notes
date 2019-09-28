package question1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {

            // 获取输入，建立辅助数组
            String s = sc.nextLine();
            int n = s.length();
            char[] nums = s.toCharArray();
            int[] aux = new int[n];

            // 存储开始坐标
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i + 1 < n; i++) {
                if (nums[i] == 'R' && nums[i + 1] == 'L')
                    list.add(i);
            }

            int begin = 0; // 起始位置
            int left = 0; // 左移的目的地

            for (int k = 0; k < list.size(); k++) {

                int right = list.get(k); // 右移的目的地
                aux[right] = aux[right + 1] = 1; // 不变量先赋值

                for (int i = begin; i < right; i++) {
                    // 右移的数据
                    if (nums[i] == 'R') {
                        int flag = (right - i) % 2;
                        if (flag == 0) aux[right]++;
                        else aux[right + 1]++;
                    }
                    // 左移的数据
                    else {
                        int flag = (left - i) % 2;
                        if (flag == 0) aux[left]++;
                        else aux[left - 1]++;
                    }
                }
                left = right + 1;
                begin = right + 2;
            }
            for (int i : aux) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}