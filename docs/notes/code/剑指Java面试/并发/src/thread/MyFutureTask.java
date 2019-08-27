package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallabel());
        Thread t = new Thread(task);
        t.start();
        if (!task.isDone()) {
            System.out.println("...");
        }
        System.out.println(task.get());
    }
}
