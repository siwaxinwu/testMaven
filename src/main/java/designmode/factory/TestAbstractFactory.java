package designmode.factory;

public class TestAbstractFactory {
    public static void main(String[] args) {
        xuefulanfactory xuefulanfactory = new xuefulanfactory();
        Chair chair = xuefulanfactory.createChair();
        Engine engine = xuefulanfactory.createEngine();
        chair.seat();
        engine.run();
    }
}
interface Engine{
    public void run();
    public void start();
}
class EngineA implements Engine {

    @Override
    public void run() {
        System.out.println("EngineA is fast");
    }

    @Override
    public void start() {
        System.out.println("EngineA is starting");

    }
}
class EngineB implements Engine {

    @Override
    public void run() {
        System.out.println("EngineB is fast");
    }

    @Override
    public void start() {
        System.out.println("EngineB is starting");

    }
}
interface Chair{
    public void seat();
}

class ChairA implements Chair{
    @Override
    public void seat() {
        System.out.println("ChairA is seating");
    }
}

class ChairB implements Chair{
    @Override
    public void seat() {
        System.out.println("ChairB is seating");
    }
}
interface AbstractFacory{
    public Engine createEngine();
    public Chair createChair();
}

class xuefulanfactory implements AbstractFacory{
    @Override
    public Engine createEngine() {
        return new EngineA();
    }

    @Override
    public Chair createChair() {
        return new ChairA();
    }
}