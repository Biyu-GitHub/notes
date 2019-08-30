package 被动引用;

public class Father {
    public static int val = 10;
    public static final int val2 = 20;

    public Father() {
        System.out.println("父类初始化");
    }
}
