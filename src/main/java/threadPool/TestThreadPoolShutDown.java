package threadPool;

import java.util.concurrent.*;

/**
 *addWorker()方法就是创建线程并执行传入的任务，
 * 第二个参数含义：true，与核心线程数比较，小于等于核心线程数就创建线程执行任务，大于等于则不增加
 * false：与最大线程数比较，
 * 布尔值的含义：判断是否新增线程的依据是以核心线程数还是最大线程数
 *
 *
 * 关于线程池的关闭：
 *   shutDown以后就不能再去提交任务了
 *   isShuntDown（）方法返回true不代表彻底关闭了，只是说已经开始关了
 *
 *
 *
 */
public class TestThreadPoolShutDown {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                100,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                new DefineRejectStrategy());
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new ShutDownTask());
        }

        Thread.sleep(1500);
        executorService.shutdown();

        //再次提交任务
        executorService.execute(new ShutDownTask());
    }
}
class ShutDownTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}

class DefineRejectStrategy implements RejectedExecutionHandler  {


    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(executor.getQueue().size());
    }
}
