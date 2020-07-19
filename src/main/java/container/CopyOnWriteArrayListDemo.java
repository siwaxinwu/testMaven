package container;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 演示CopyOnWriteArrayList迭代期间可以修改集合的内容
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> list =
                new CopyOnWriteArrayList<>(new Integer[]{1, 2, 3});
        System.out.println(list);
        Iterator<Integer> iterator = list.iterator();
        list.add(4);
        System.out.println(list);
        Iterator<Integer> iterator1 = list.iterator();
        System.out.println("verify 1");
        iterator.forEachRemaining(System.out::println);
        

    }
}
