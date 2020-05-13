package designmode.singleton0505;

/**
 * 饿汉式单例,天生线程安全，
 * 单例模式：只有一个，节省内存，方便管理，重复利用
 */
public class HungrySingleton {
    public static final HungrySingleton singleton = new HungrySingleton();
    private HungrySingleton(){}
    public static  HungrySingleton getInstance(){
        return singleton;
    }

    public static void main(String[] args) {
        System.out.println(HungrySingleton.getInstance());
        System.out.println(HungrySingleton.getInstance());

    }
}
