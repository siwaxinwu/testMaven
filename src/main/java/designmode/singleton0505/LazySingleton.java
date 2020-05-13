package designmode.singleton0505;

/**
 * 懒汉式，非线程安全
 */
public class LazySingleton {
    public static LazySingleton singleton = null;
    private LazySingleton(){}
    public static synchronized LazySingleton getInstance(){
        if (null == singleton) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(LazySingleton.getInstance());
        System.out.println(LazySingleton.getInstance());
    }

}
