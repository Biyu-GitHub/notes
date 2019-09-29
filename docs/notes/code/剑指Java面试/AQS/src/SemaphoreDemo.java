import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    private static final int threadNums = 20;

    public static void test(int threadNums) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadNums; i++) {
            int id = i;
            threadPool.execute(() -> {
                try {
                    semaphore.acquire(3);
                    test(id);
                    semaphore.release(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("Finished");
        threadPool.shutdown();
    }
}
