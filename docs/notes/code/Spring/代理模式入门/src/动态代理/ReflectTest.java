package 动态代理;

public class ReflectTest {
    public static void main(String[] args) {
        Fruit fruit = (Fruit) DynamicAgent.agent(Fruit.class, new Apple());
        fruit.show();
    }
}
