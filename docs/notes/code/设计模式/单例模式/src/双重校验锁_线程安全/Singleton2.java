package 双重校验锁_线程安全;

/**
 * 双重校验锁优化
 */
public class Singleton2 {
    private static volatile Singleton2 uniqueInstance;

    private Singleton2() {

    }

    public static Singleton2 getUniqueInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Singleton2();

        return uniqueInstance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton2.getUniqueInstance())).start();
        }
    }
}
