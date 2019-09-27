package 动态代理;

public class Main {
    public static void main(String[] args) {
        IDBQuery proxy = DBQueryHandler.createProxy();
        System.out.println(proxy.request());
    }
}
