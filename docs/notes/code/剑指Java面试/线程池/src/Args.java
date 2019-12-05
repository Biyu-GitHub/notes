import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Args {

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        Thread thread = new Thread();
        Stack<Integer> stack = new Stack<>();
        List<Object> list = Collections.synchronizedList(new ArrayList<>());
        list.add(10);
        System.out.println(list.get(0));
        CopyOnWriteArrayList<Integer> writeArrayList = new CopyOnWriteArrayList<>();
        writeArrayList.add(100);
        System.out.println(writeArrayList.get(0));
    }
}
