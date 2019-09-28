package question3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // 缓存服务器对应的节点
    public static HashMap<Integer, Integer> map;

    public Main() {

        map = new HashMap<>(20);

        for (int i = 1, node = 0; i <= 20; i++, node += 50) {
            map.put(i, node);
        }
    }

    public static void redis(String cmd, String content) {
        switch (cmd) {
            case "1":
                one(content);
                break;
            case "2":
                two(content);
                break;
            case "3":
                three(content);
                break;
            case "4":
                four(content);
                break;
//            case "1":
//                five(content);
//                break;
            default:
                break;
        }
    }

    private static void four(String content) {
        Integer id = Integer.valueOf(content.split("_")[1]);

        id = map.get(id) + 25;

        if (id % 2 == 0)
            id += 500;

        System.out.println(id);
    }

    // 1. 服务器的节点号
    private static void one(String content) {
        Integer id = Integer.valueOf(content.split("_")[1]);
        System.out.println(map.get(id));
    }

    // 2. token落入的节点号
    private static int two(String content) {

        // 先求节点号
        char[] token = content.toCharArray();
        int node = 0;
        for (char c : token) {
            node += c;
        }
        node %= 999;

        if (node > 950) {
            System.out.println(0);
            return 0;
        }

        for (int i = 1; i <= 20; i++) {
            int id = map.get(i);
            if (id >= node) {
                System.out.println(id);
                return i;
            }
        }
        return -1;
    }

    // 3. 有宕机的节点
    private static void three(String content) {
        boolean[] nums = new boolean[21];
        Arrays.fill(nums, true);
        nums[0] = false;

        String[] inputs = content.split(";");
        String[] redises = inputs[0].split(",");
        char[] token = inputs[1].toCharArray();

        // 记录宕机的服务器
        for (String redis : redises) {
            int index = Integer.valueOf(redis.split("_")[1]);
            nums[index] = false;
        }

        // 先求节点号
        int id = 0;
        int node = 0;
        for (char c : token) {
            node += c;
        }
        node %= 999;

        if (node > 950) {
            id = 0;
        } else {
            for (id = 1; id <= 20; id++) {
                int temp = map.get(id);
                if (temp >= node) {
                    break;
                }
            }
        }

        while (!nums[id]) {
            id++;
            if (id == 21)
                id = 1;
        }

        System.out.println(map.get(id));

    }

    public static void main(String[] args) {

        Main m = new Main();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String[] inputs = sc.nextLine().split(":");
            String cmd = inputs[0];
            String content = inputs[1];
            redis(cmd, content);
        }
    }
}
