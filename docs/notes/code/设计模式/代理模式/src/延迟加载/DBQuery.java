package 延迟加载;

public class DBQuery implements IDBQuery {

    public DBQuery() {
        try {
            Thread.sleep(1000); //假设数据库连接等耗时操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        return "Request string";
    }
}
