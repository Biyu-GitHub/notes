package 双重校验锁_线程安全.复习;

public class Singleton {
    private static volatile Singleton uniqueInstence;

    private Singleton() {
    }

    public static Singleton getUniqueInstence() {
        if (uniqueInstence == null) {
            synchronized (Singleton.class) {
                if (uniqueInstence == null)
                    uniqueInstence = new Singleton();
            }
        }
        return uniqueInstence;
    }
}
