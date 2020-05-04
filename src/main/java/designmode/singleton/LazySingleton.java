package designmode.singleton;

public class LazySingleton {
    private static LazySingleton lazySingleton;
    private LazySingleton(){

    }
    public static synchronized LazySingleton getInstance(){
        if (null == lazySingleton) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
