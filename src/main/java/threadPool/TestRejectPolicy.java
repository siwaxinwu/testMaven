/*
package threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

*/
/**
 *测试线程池的拒绝策略
 * 兴建线程池不建议使用ThreadPoolExecuter,不能具体到线程池的具体参数，容易引发OOM
 * 比如newFixedThreadPool和newSingleThreadPool的阻塞队列的大小等于int的最大值，容易
 * 堆积任务导致OOM
 * newScheduleThreadPool和newCachedThreadPool的最大线程数无限大，会创建大量的线程导致OOM
 *//*

public class TestRejectPolicy {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                3,
                10,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(2),
                new ThreadPoolExecutor.AbortPolicy());
            for (int i = 0; i < 6; i++) {
            executor.execute(() ->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        int size = executor.getQueue().size();
        executor.shutdown();

    }
}
*/
