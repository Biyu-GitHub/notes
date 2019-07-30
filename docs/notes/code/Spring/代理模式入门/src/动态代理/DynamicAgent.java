package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicAgent {

    static class MyHandler implements InvocationHandler {
        private Object proxy;

        public MyHandler(Object proxy) {
            this.proxy = proxy;
        }

        /**
         * 自定义invoke方法
         *
         * @param proxy  被代理的类的实例
         * @param method 调用被代理的类的方法
         * @param args   该方法需要的参数
         * @return
         * @throws Throwable
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(">>>>before invoking");
            Object ret = method.invoke(this.proxy, args);
            System.out.println(">>>>after invoking");
            return ret;
        }
    }

    /**
     * 被代理的类的类加载器
     * 被代理类的接口数组
     * 就是刚刚介绍的调用处理器类的对象实例
     */
    public static Object agent(Class interfaceClazz, Object proxy) {
        return Proxy.newProxyInstance(
                interfaceClazz.getClassLoader(),
                new Class[]{interfaceClazz},
                new MyHandler(proxy));
    }
}
