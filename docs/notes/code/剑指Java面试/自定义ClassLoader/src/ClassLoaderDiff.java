public class ClassLoaderDiff {
    public static void main(String[] args) throws ClassNotFoundException {
        Test.class.getClassLoader().loadClass("Test");
        Class.forName("Test");
    }
}
