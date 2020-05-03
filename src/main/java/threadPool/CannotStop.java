/*
package threadPool;



import java.util.concurrent.ArrayBlockingQueue;

public class CannotStop  {
    public static void main(String[] args) throws InterruptedException  {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(10);
        Runnable producer = () -> {
            while (true) {
                try {
                    blockingQueue.put(new Object());
                    System.out.println("生产了一个object");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();

        Runnable consumer = () -> {
            while (true) {
                try {
                    Object take = blockingQueue.take();
                    System.out.println("消费了一个object：" + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(consumer).start();
        new Thread(consumer).start();

    }



}

*/
