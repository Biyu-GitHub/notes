package 小易的英语软件;

import java.util.*;

/**
 * 小易的英语软件
 * ===========================
 * 输入：
 * 学生的人数 n
 * 每个学生的分数 a1 a2 a3 ... an
 * 查询的次数 q
 * 查询的id1
 * 查询的id2
 * ...
 * 查询的idq
 * ===========================
 * 输出：
 * 在该学生排名之后的人数，占总人数的百分比，保留6位小数
 * ===========================
 * 例如：
 * 输入:
 * 3
 * 100 99 98
 * 3
 * 1
 * 2
 * 3
 * 输出：
 * 66.666667
 * 33.333333
 * 0.000000
 */
public class Main {

    ArrayList<Score> list;
    Map<Integer, Integer> map;

    /**
     * 存储学号和分数
     */
    class Score {
        int id;
        int score;

        public Score(int id, int score) {
            this.id = id;
            this.score = score;
        }
    }

    /**
     * 构造函数，传入学生的分数列表，创建对象直接成成排名用的哈希表
     *
     * @param arr 分数列表
     * @param n   学生人数
     */
    public Main(int[] arr, int n) {
        list = new ArrayList<>(n);
        map = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            list.add(new Score(i, arr[i]));
        }

        list.sort((o1, o2) -> o2.score - o1.score);

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).id, i);
        }
    }

    /**
     * 直接查询哈希表返回学生的排名情况
     * (n - 1 - 排名) / n * 100;
     * 保留小数可以使用格式化输出：System.out.printf("%.6f\n", double);
     *
     * @param n  学生人数
     * @param id 学生id
     * @return
     */
    public double findRank(int n, int id) {
        return (n - 1.0d - map.get(id - 1)) / n * 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int q = sc.nextInt();

        Main main = new Main(arr, n);

        for (int i = 0; i < q; i++) {
            System.out.printf("%.6f\n", main.findRank(n, sc.nextInt()));
        }

        sc.close();
    }
}
