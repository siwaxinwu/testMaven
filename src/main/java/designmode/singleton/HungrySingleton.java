package designmode.singleton;
/*
*单例模式好处：节约内存、重复利用、方便管理
*缺点：线程安全问题
* 7种创建方式： 饿汉式、懒汉式、静态内部方式、枚举单例、双重检验锁方式
* 饿汉式：类初始化的时候，会立即加载该对象，线程天生安全，调用效率高
* 懒汉式：类初始化的时候不会加载该对象，真正需要使用的时候才会创建该对象，具有懒加载功能
* 静态内部方式：结合了饿汉式和懒汉式的优点，懒加载并线程安全
*
*
* */
public class HungrySingleton {
    private static final HungrySingleton singleton = new HungrySingleton();
    private HungrySingleton(){}

    public static HungrySingleton getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance1 = HungrySingleton.getInstance();
        System.out.println(instance == instance1);
    }
}
