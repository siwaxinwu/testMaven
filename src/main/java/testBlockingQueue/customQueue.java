package testBlockingQueue;

import java.awt.image.ImageProducer;
import java.util.LinkedList;
import java.util.Queue;
/*
* 自定义消费队列
*
* */
public class customQueue {
    private static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        producer();
        consumer();
    }

    private static void producer() {
        queue.add("first message");
        queue.add("second message");
        queue.add("third message");
    }


    private static void consumer() {
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
