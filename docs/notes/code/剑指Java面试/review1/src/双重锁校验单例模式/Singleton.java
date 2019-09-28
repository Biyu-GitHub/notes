package 双重锁校验单例模式;

public class Singleton {

    private volatile static Singleton uniqueinstance;

    private Singleton() {
    }

    public static Singleton getUniqueinstance() {
        if (uniqueinstance == null) {
            synchronized (Singleton.class) {
                if (uniqueinstance == null) {
                    uniqueinstance = new Singleton();
                }
            }
        }
        return uniqueinstance;
    }
}
