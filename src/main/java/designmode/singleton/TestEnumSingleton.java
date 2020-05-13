package designmode.singleton;

/**
 * 枚举内部的构造方法构建对象的
 */
public class TestEnumSingleton {
    private TestEnumSingleton(){}
    static enum EnumSingleton{
        INSTANCE;
        private TestEnumSingleton testEnumSingleton;
        private EnumSingleton(){
            testEnumSingleton = new TestEnumSingleton();
        }
        public TestEnumSingleton getInstance(){
            return this.testEnumSingleton;
        }
    }
    public static TestEnumSingleton getInstance(){
        return EnumSingleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        TestEnumSingleton instance = TestEnumSingleton.getInstance();
        TestEnumSingleton instance1 = TestEnumSingleton.getInstance();
        System.out.println(instance);
        System.out.println(instance1);

    }
}
