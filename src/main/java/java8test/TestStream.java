package java8test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//演示创建流的几种方式
public class TestStream {
    public static void main(String[] args) {
        //创建顺序流和并行流
        List<String> list = new ArrayList<>();
        list.stream();
        list.parallelStream();

        //Arrays类的stream()方法来创建Stream流
        Integer[] nums = new Integer[]{1,2,3,4,5,6,7,8,9};
        Stream<Integer> numStream = Arrays.stream(nums);

        //of方法创建一个Stream流
        Stream<String> strStream = Stream.of("a", "b", "c");

        //创建无限流
        Stream<Integer> intStream = Stream.iterate(0, (x) -> x + 2);
        intStream.forEach(System.out::println);
        intStream.limit(10).forEach(System.out::println);

        Stream.generate(() -> Math.random()).forEach(System.out::println);
        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);

        //创建空流
        Stream<String> empty = Stream.empty();

    }

    @Test
    public void test(){
        Stream<Integer> intStream = Stream.iterate(0, (x) -> x + 2);
        //intStream.forEach(System.out::println);
        intStream.limit(10).forEach(System.out::println);
        
    }
}
