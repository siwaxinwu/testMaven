package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.reflect.generics.scope.MethodScope;

import java.lang.reflect.Method;

public class TestCglib0501 implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if ("printA".equals(method.getName())){
            System.out.println("printA is working");
        }
        if ("printB".equals(method.getName())){
            System.out.println("printB is working");
        }
        return null;
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Demo.class);
        enhancer.setCallback(new TestCglib0501());
        Demo demo = (Demo)enhancer.create();
        demo.printA();
    }
}
