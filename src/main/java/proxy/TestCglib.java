package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCglib implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib is working");
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }

    public static void main(String[] args) {
        Car car = new Car();
        Enhancer enhancer = new Enhancer();
        //设置父类为实例类
        enhancer.setSuperclass(car.getClass());
        //回调方法
        enhancer.setCallback(new TestCglib());
        Car carProxy = (Car)enhancer.create();
        car.run();


    }
    static class Car {
        public void run(){
            System.out.println("the car is running");
        }
    }
}
