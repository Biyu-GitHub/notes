package thread;

/**
 * 处理线程的返回值
 */
public class ReturnCycleWait implements Runnable{
    private String value;

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "ReturnCycleWait";
    }

    public static void main(String[] args) throws InterruptedException {
        ReturnCycleWait r = new ReturnCycleWait();
        Thread t = new Thread(r);
        t.start();

//        // 主线程循环等待法
//        while (r.value == null) {
//            Thread.currentThread().sleep(100);
//        }

        // 阻塞法，阻塞当前线程来等待子线程运行完成
        t.join();
        System.out.println(r.value);
    }
}
