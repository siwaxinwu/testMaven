package designmode.decorate;

/**
 * 模拟咖啡
 * 1、抽象组件：需要装饰的的抽象对象（接口或者抽象父类）
 * 2.具体组件：需要装饰的对象
 * 3.抽象装饰类：包含了对抽象组件的引用以及装饰者共有的方法
 * 4.具体装饰类：被装饰的对象
 */
public class TestDecorate1 {
    public static void main(String[] args) {
        Drink coffee = new coffee();
        Sugar sugar = new Sugar(coffee);
        System.out.println("加了糖以后的价格" + sugar.cost());
        System.out.println("加了糖以后的说明" + sugar.info() );

        Milk milk = new Milk(sugar);
        System.out.println("加了牛奶以后的价格" + milk.cost());
        System.out.println("加了牛奶以后的说明" + milk.info() );
    }

}
//抽象组件
interface Drink{
    double cost();
    String info();
}
//具体组件
class coffee implements Drink {
    private String name = "ruixing";

    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}
//抽象装饰类
abstract class Decorate implements Drink{
    //对抽象组件的引用
    private Drink drink;

    public Decorate(Drink drink) {
        this.drink = drink;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}

//具体装饰类
class Milk extends Decorate {
    public Milk(Drink drink) {
        super(drink);
    }
    @Override
    public double cost() {
        return super.cost() *10;
    }

    @Override
    public String info() {
        return super.info() + "加入了牛奶";
    }
}

//具体装饰类
class Sugar extends Decorate {
    public Sugar(Drink drink) {
        super(drink);
    }
    @Override
    public double cost() {
        return super.cost() *100;
    }
    @Override
    public String info() {
        return super.info() + "加入了糖";
    }
}