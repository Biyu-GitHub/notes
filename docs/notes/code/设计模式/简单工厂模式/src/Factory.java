public class Factory {
    public static Shape getProduct(String name) {
        if (name == null)
            return null;

        switch (name) {
            case "Circle":
                return new Circle();
            case "Rectangle":
                return new Rectangle();
            case "Square":
                return new Square();
            default:
                return null;
        }
    }
}
