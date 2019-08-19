package threadsafe;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(1);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(threadLocal.get());
                threadLocal.remove();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(2);
                System.out.println(threadLocal.get());
                threadLocal.remove();
            }
        });

        thread1.start();
        thread2.start();
    }
}
