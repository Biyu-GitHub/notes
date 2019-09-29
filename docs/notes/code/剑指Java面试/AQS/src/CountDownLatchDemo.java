import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    private static final int threadNums = 100;

    public static void test(int threadNums) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(threadNums);
        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < threadNums; i++) {
            threadPool.execute(() -> {
                try {
                    test(threadNums);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    cdl.countDown();
                }
            });
        }
//        cdl.await(10, TimeUnit.MILLISECONDS);
        cdl.await();
        System.out.println("Finished");
        threadPool.shutdown();
    }
}
