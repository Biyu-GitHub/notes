package threadsafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 不可变的集合类型
 * Exception in thread "main" java.lang.UnsupportedOperationException
 */
public class Unmodified {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        Map<Integer, Integer> unmodifiableMap = Collections.unmodifiableMap(map);

        unmodifiableMap.put(2, 2);
    }
}
