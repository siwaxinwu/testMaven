package java8test.lambda;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test1 {
    @Test
    public void test1() {
        NoReturnNoParam noReturnNoParam = () ->{
            System.out.println("noReturnNoParam");
        };
        noReturnNoParam.method();

    }

    @Test
    public void test2(){
        NoReturnOneParam noReturnOneParam = (int a) ->{
            System.out.println("noReturnOneParam" + a);
        };
        noReturnOneParam.method(22);
    }

    @Test
    public void test3(){
        NoReturnOneParam noReturnOneParam = (int a) ->{
            System.out.println("noReturnOneParam" + a);
        };
        noReturnOneParam.method(22);
    }
    //消费消息
    @Test
    public void test4(){
        Consumer<String> consumer = (ele) ->{
            System.out.println("consumer" + ele);
        };
        consumer.accept("ok");
    }

    //判断真假
    @Test
    public void test5(){
        Predicate<Integer> predicate = (x) -> { return x >= 34;};
        boolean youare = predicate.test(6);
        System.out.println(youare);
    }

    //T 转换成R
    /*@Test
    public void test6(){
        Function<String, Integer> function = (String a, Integer b)-> {
            Integer.valueOf("a");
        };
    }*/


}
