package designmode;

import org.apache.commons.lang3.StringUtils;

/**
 * 简单工厂模式
 * 内型非常多的时候，难于扩展
 * 工厂模式分为简单工厂、工厂方法、抽象工厂模式
 *
 * */


public class SimpleFactory {
    public static Car createCar(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        if(name.equals("奥迪")){
            return new AoDi();
        }
        if(name.equals("吉利")){
            return new JiLi();
        }
        return null;
    }
    public static void main(String[] args) {
        Car aodi  =SimpleFactory.createCar("奥迪");
        Car jili  =SimpleFactory.createCar("吉利");
        aodi.run();
        jili.run();
    }

}
interface Car {
    public void run();
}

class JiLi implements Car {
    public void run() {
        System.out.println("我是吉利汽车...");
    }
}

class AoDi implements Car {
    public void run() {
        System.out.println("我是奥迪汽车..");
    }
}
