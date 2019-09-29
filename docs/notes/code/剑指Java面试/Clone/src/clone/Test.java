package clone;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Example e1 = new Example();
        Example e2 = (Example) e1.clone();
        System.out.println(e1.nums[0]);
        System.out.println(e2.nums[0]);

        e1.nums[0] = 100;
        System.out.println(e1.nums[0]);
        System.out.println(e2.nums[0]);
    }
}
