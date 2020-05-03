//package designmode;
//
//public class FactoryMethod {
//    public static void main(String[] args) {
//        JiLiFactory jiLiFactory = new JiLiFactory();
//        Car jili = jiLiFactory.createCar("吉利");
//        jili.run();
//    }
//
//}
//
//
//
//interface carFactory{
//    public Car createCar(String name);
//}
//class JiLiFactory implements carFactory {
//
//    @Override
//    public Car createCar(String name) {
//        return new JiLi();
//    }
//}
//
//class AoDiFactory implements carFactory{
//
//    @Override
//    public Car createCar(String name) {
//        return new AoDi();
//    }
//}
//interface Car {
//    public void run();
//}
//class JiLi implements Car {
//    public void run() {
//        System.out.println("我是吉利汽车...");
//    }
//}
//
//class AoDi implements Car {
//    public void run() {
//        System.out.println("我是奥迪汽车..");
//    }
//}
