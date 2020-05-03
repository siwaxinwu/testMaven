package testBlockingQueue;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
/*
* 自定义一个延迟消息队列
* */
public class CustomdelayQueue {
    private static DelayQueue<MyDelay> delayQueue = new DelayQueue<MyDelay>();

    public static void main(String[] args) throws InterruptedException {
        producer();
        consumer();
    }

    private static void consumer() throws InterruptedException {
        System.out.println("start time" + DateFormat.getDateTimeInstance().format(new Date()));
        while (!delayQueue.isEmpty()){
            System.out.println(delayQueue.take());
        }
        System.out.println("end time" + DateFormat.getDateTimeInstance().format(new Date()));
    }

    private static void producer() {
        delayQueue.put(new MyDelay(10000, "消息1"));
        delayQueue.put(new MyDelay(3000, "消息2"));

    }
}
