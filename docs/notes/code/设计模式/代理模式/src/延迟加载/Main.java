package 延迟加载;

public class Main {
    public static void main(String[] args) {
        IDBQuery q = new DBQueryProxy();
        q.request();
    }
}
