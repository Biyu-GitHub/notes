public class SimpleAOPTest {
    public static void main(String[] args) {
        MethodInvocation logTask = new MethodInvocation() {
            @Override
            public void invoke() {
                System.out.println("log task start");
            }
        };

        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        BeforeAdvice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);

        HelloService proxy = (HelloService) SimpleAOP.getProxy(helloServiceImpl, beforeAdvice);

        proxy.sayHelloWorld();
    }
}
