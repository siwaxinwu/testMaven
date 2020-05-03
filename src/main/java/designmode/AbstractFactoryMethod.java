package designmode;

/**
 * 抽象工厂用于组合工厂，是工厂的工厂
 */

public class AbstractFactoryMethod {
    public static void main(String[] args) {
        CarFactory carFactory=new JiLiFactory();
        Engine engine=carFactory.createEngine();
        engine.run();
        engine.start();
    }
}
//发动机
interface Engine {

    void run();

    void start();
}
class EngineA implements Engine {

    public void run() {
        System.out.println("转的快!");
    }

    public void start() {
        System.out.println("启动快,自动档");
    }

}

class EngineB implements Engine {

    public void run() {
        System.out.println("转的慢!");
    }

    public void start() {
        System.out.println("启动快,手动档");
    }

}
//座椅
interface Chair {
    void run();
}
class ChairA implements Chair{

    public void run() {
        System.out.println("可以自动加热!");
    }

}
class ChairB implements Chair{

    public void run() {
        System.out.println("不能加热!");
    }

}
interface CarFactory {
    // 创建发动机
    Engine createEngine();
    // 创建座椅
    Chair createChair();
}

class JiLiFactory implements CarFactory  {

    public Engine createEngine() {
        return new EngineA();
    }

    public Chair createChair() {
        return new ChairA();
    }

}
