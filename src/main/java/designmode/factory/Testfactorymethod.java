package designmode.factory;
/*
* 简单工厂、工厂方法、抽象工厂
*
* */
public class Testfactorymethod {
    public static void main(String[] args) {
        XuefulanFactory xuefulanFactory = new XuefulanFactory();
        Car car = xuefulanFactory.createCar();
        car.run();
    }

}
interface FactoryMethod{
    public Car createCar();
}
class XuefulanFactory implements FactoryMethod{

    @Override
    public Car createCar() {
        return new Xuefulan();
    }
}

class BaomaFactory implements FactoryMethod {

    @Override
    public Car createCar() {
        return new Baoma();
    }
}