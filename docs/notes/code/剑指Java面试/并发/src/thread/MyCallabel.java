package thread;

import java.util.concurrent.Callable;

public class MyCallabel implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "Callable test";
        System.out.println("test begin");
        Thread.currentThread().sleep(3000);
        System.out.println("test done");
        return value;
    }
}
