package designmode.singleton0505;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

/**
 * 对象的创建放在枚举的构造方法当中
 * 双重检验锁方式要判断两层null
 */
public class TestEnumSingleton {
    static enum  Singleton{
        INSTANCE;
        private TestEnumSingleton singleton;
        private Singleton(){
            singleton = new TestEnumSingleton();
        }
        public TestEnumSingleton getInstance(){
            return this.singleton;
        }

    }
    public static TestEnumSingleton getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        System.out.println(TestEnumSingleton.getInstance());
        System.out.println(TestEnumSingleton.getInstance());
    }
}
