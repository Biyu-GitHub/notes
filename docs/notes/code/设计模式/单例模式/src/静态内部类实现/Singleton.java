package 静态内部类实现;

/**
 * 静态内部类：
 *  定义在了成员位置上，并且使用static来去修饰。
 */

public class Singleton {
    private Singleton() {
        System.out.println("outer");
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }

}
