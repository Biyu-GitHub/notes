public class CircleFactory implements AbstractFactory {
    @Override
    public Shape getShape() {
        return new Circle();
    }
}
