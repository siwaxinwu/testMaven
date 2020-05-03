package designmode;

/**
 * 1、Builder：给出一个抽象接口，以规范产品对象的各个组成成分的建造。这个接口规定要实现复杂对象的哪些部分的创建，
 * 并不涉及具体的对象部件的创建。
 * 2、ConcreteBuilder：实现Builder接口，针对不同的商业逻辑，具体化复杂对象的各部分的创建。
 * 在建造过程完成后，提供产品的实例。
 * 3、Director：调用具体建造者来创建复杂对象的各个部分，在指导者中不涉及具体产品的信息，
 * 只负责保证对象各部分完整创建或按某种顺序创建。
 * 4、Product：要创建的复杂对象。
 *
 * 建造者应用场景
 * 1、去肯德基，汉堡、可乐、薯条、炸鸡翅等是不变的，而其组合是经常变化的，生成出所谓的"套餐"。
 * 2、JAVA 中的 StringBuilder。
 * 使用场景：
 * 1、需要生成的对象具有复杂的内部结构。
 * 2、需要生成的对象内部属性本身相互依赖。
 * 与工厂模式的区别是：建造者模式更加关注与零件装配的顺序。
 */
public class PersonDirector{
    public Person constructPerson(PersonBuilder pb) {
        pb.builderHead();
        pb.builderBody();
        pb.builderFoot();
        return pb.BuilderPersion();
    }

    public static void main(String[] args) {
        PersonDirector pb = new PersonDirector();
        Person person = pb.constructPerson(new ManBuilder());
        System.out.println(person.getHead());
        System.out.println(person.getBody());
        System.out.println(person.getFoot());
    }

}


class ManBuilder implements PersonBuilder {
    private Person person;
    @Override
    public void builderHead() {
        person.setHead("建造者头部");
    }

    @Override
    public void builderBody() {
        person.setBody("建造者身体部分");
    }

    @Override
    public void builderFoot() {
        person.setFoot("建造者头四肢部分");
    }

    @Override
    public Person BuilderPersion() {
        return person;
    }
}



interface PersonBuilder {

    void builderHead();

    void builderBody();

    void builderFoot();

    Person BuilderPersion(); //组装
}

class Person {
    private String head;
    private String body;
    private String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

}