package designmode.factory;


public class TestSimpleFactory {
    public static Car createCar(String names) {
        if ("xuefulan".equals(names)) {
            return new Xuefulan();
        }
        if ("baoma".equals(names)) {
            return new Baoma();
        }
        return null;
    }

    public static void main(String[] args) {
        Car xuefulan = TestSimpleFactory.createCar("xuefulan");
        xuefulan.run();
    }

}

interface Car {
    public void run();
}

class Xuefulan implements Car {
    @Override
    public void run() {
        System.out.println("Xuefulan is running");
    }
}

class Baoma implements Car {

    @Override
    public void run() {
        System.out.println("baoma is running");
    }
}
