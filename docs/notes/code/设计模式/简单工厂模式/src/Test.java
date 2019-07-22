public class Test {
    public static void main(String[] args) {
        Shape shape1 = Factory.getProduct("Rectangle");
        shape1.draw();

        Shape shape2 = Factory.getProduct("Circle");
        shape2.draw();

        Shape shape3 = Factory.getProduct("Square");
        shape3.draw();
    }
}
