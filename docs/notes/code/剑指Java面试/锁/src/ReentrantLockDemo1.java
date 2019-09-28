import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo1 {

    private static int count;
    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 2; i++) {
            executor.execute(() -> {
                add();
            });
        }

        executor.shutdown();
    }

    public static void add() {
        while (count <= 8) {
            lock.lock();
            count++;
            System.out.println(Thread.currentThread().getName() + ": " + count);
            lock.unlock();
        }
    }
}
