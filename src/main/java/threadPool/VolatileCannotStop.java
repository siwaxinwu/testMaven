package threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 看看阻塞队列的特性
 * 先停生产的，再停消费的
 */
public class VolatileCannotStop  {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(8);
        Producer producer = new Producer(blockingQueue);
        Thread thread = new Thread(producer);
        thread.start();
        Thread.sleep(500);
        System.out.println(producer.storage);
        Consumer consumer = new Consumer(blockingQueue);
        while (consumer.needMoreConsumer()) {
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了");
        producer.canceled = true;
        System.out.println(producer.canceled);
        System.out.println(producer.storage);


    }


}

class Producer implements Runnable{
    public volatile  boolean canceled = false;
    public BlockingQueue storage;

    public Producer(BlockingQueue storage){
        this.storage = storage;
    }
    @Override
    public void run() {
        int num = 0;
        try {
            while (!canceled ){
                if (num % 10 == 0){
                    if (storage.size() ==8){
                        Thread.sleep(500);
                    }
                    storage.put(num);
                    System.out.println(num + "是10的倍数,放入仓库了");
                }
                num ++;
            }

        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者运行结束");
        }

    }
}

class Consumer{
    public BlockingQueue storage;
    public Consumer(BlockingQueue storage){
        this.storage = storage;
    }
    public  static boolean needMoreConsumer(){
        if (Math.random() > 0.97) {
            return false;
        }
        return true;
    }
}