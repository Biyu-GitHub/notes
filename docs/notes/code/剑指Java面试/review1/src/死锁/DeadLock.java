package 死锁;

public class DeadLock {
    public static Object resources1 = new Object();
    public static Object resources2 = new Object();


    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (resources1) {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("waiting tes2");
                synchronized (resources2) {
                    System.out.println("got res 2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resources2) {
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("waiting tes1");
                synchronized (resources1) {
                    System.out.println("got res 1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
