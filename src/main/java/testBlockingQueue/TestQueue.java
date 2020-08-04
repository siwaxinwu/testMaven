package testBlockingQueue;





import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *并发队列：阻塞队列和非阻塞队列，我们正常使用的阻塞队列，
 *Dequeue:double-end-queue
 * 是线程安全的
 * queue抛异常的一组方法add、remove、element
 * offer、poll、peek，poll和peek都会返回队列的头元素，poll会删除队列的头元素
 * put和take方法会阻塞的
 */
public class TestQueue {

    @Test
    public void test(){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);
    }

    @Test
    public void test11(){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove();
        queue.remove();
        queue.remove();
        //queue.remove();

    }
    @Test
    public void test111(){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        //queue.element();

    }


}
