package deadlock;

public class DeadLockDemo {
    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + "get resource1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "waiting resource2...");
                    synchronized (resource2) {
                        System.out.println(Thread.currentThread().getName() + "get resource2");
                    }
                }
            }
        },"Thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + "get resource2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "waiting resource1...");
                    synchronized (resource1) {
                        System.out.println(Thread.currentThread().getName() + "get resource1");
                    }
                }
            }
        },"Thread2").start();
    }
}
