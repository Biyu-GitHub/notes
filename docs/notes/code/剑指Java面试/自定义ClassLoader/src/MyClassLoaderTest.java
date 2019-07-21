public class MyClassLoaderTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MyClassLoader m = new MyClassLoader("D:\\Projects\\GitHub\\notes\\docs\\notes\\code\\剑指Java面试\\自定义ClassLoader\\src\\", "test");
        Class test = m.findClass("Test");
        System.out.println(test.getClassLoader().getParent());
        System.out.println(test.getClassLoader().getParent().getParent());
        System.out.println(test.getClassLoader().getParent().getParent().getParent());
        test.newInstance();


    }
}
