package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(1);
        i.incrementAndGet();
    }
}
