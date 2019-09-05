package question2;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现LRU
 */
public class Solution extends LinkedHashMap {

    private int capacity;

    public Solution(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return (int) super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        Solution s = new Solution(2);
        s.put(1, 1);
        s.put(2, 2);
        System.out.println(s.get(1));
        s.put(3, 3);
        System.out.println(s.get(2));
        s.put(4, 4);
        System.out.println(s.get(1));
    }
}
