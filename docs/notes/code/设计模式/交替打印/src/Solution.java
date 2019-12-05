import java.util.concurrent.locks.ReentrantLock;

public class Solution implements Runnable {

    private static int i = 1;
    private static ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (i < 100) {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ":" + i++);
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(new Solution(), "-").start();
        new Thread(new Solution(), "---").start();
    }
}
