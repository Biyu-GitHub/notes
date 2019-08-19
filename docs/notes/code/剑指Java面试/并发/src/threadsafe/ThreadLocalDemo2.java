package threadsafe;

import java.util.HashMap;

public class ThreadLocalDemo2 {

    private static class MyThreadLocal {
        private static HashMap<Thread, Integer> map = new HashMap<>();

        private static void set(Integer i) {
            map.put(Thread.currentThread(), i);
        }

        private static Integer get() {
            return map.get(Thread.currentThread());
        }
    }


    public static void main(String[] args) {

        MyThreadLocal threadLocal = new MyThreadLocal();

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
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(2);
                System.out.println(threadLocal.get());
            }
        });

        thread1.start();
        thread2.start();
    }
}
