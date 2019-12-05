import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumer extends Thread {

    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    static class Producer extends Thread {
        @Override
        public void run() {
            try {
                queue.put("PPP");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产");
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费");
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        for (int i = 0; i < 3; i++) {
            new Producer().start();
        }

        for (int i = 0; i < 5; i++) {
            new Consumer().start();
        }

        for (int i = 0; i < 2; i++) {
            new Producer().start();
        }
    }

}
