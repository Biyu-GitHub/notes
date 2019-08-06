import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {
    ReentrantLock lock = new ReentrantLock();
    Condition firstCondition = lock.newCondition();
    Condition secondCondition = lock.newCondition();
    Condition thiedCondition = lock.newCondition();
    int state = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        lock.lock();
        if (state != 1)
            firstCondition.await();
        state = 2;
        printFirst.run();
        secondCondition.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        lock.lock();
        if (state != 2)
            secondCondition.await();
        state = 3;
        printSecond.run();
        thiedCondition.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        lock.lock();
        if (state != 3)
            thiedCondition.await();
        printThird.run();
        lock.unlock();
    }
}