package proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy0501 implements InvocationHandler {
    public Object target;
    public TestJDKProxy0501(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("printA".equals(method.getName())) {
            System.out.println("printA is working");
        }
        if ("printB".equals(method.getName())) {
            System.out.println("printB is working");
        }
        return proxy;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        DemoInterface o =(DemoInterface) Proxy.newProxyInstance(
                demo.getClass().getClassLoader(),
                demo.getClass().getInterfaces(),
                new TestJDKProxy0501(demo));
        o.printB();
    }
}
interface DemoInterface{
    public void printA();
    public void printB();
}
class Demo implements DemoInterface{
    public void printA(){
        System.out.println("print A");
    }
    public void printB(){
        System.out.println("print B");
    }

}