package designmode.singleton;
/*
* 因为JVM本质重排序的问题，可能会初始化多次
* */
public class DoubleCheckLockSingleton {
    private static volatile DoubleCheckLockSingleton doubleCheckLockSingleton;
    private DoubleCheckLockSingleton(){

    }
    public static DoubleCheckLockSingleton getInstance(){
        if (null == doubleCheckLockSingleton) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (null == doubleCheckLockSingleton) {
                    doubleCheckLockSingleton = new DoubleCheckLockSingleton();
                }
            }
        }
        return doubleCheckLockSingleton;
    }
}
