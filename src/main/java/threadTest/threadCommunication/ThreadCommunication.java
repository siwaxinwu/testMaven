package threadTest.threadCommunication;


import org.junit.jupiter.api.Test;
import testFor.A;

import java.util.concurrent.*;


/**
 * description：
 * author：dingyawu
 * date：created in 17:36 2020/8/3
 * history:
 */
public class ThreadCommunication {
    //如何让两个线程依次执行
    public static void demo1(){
        Thread threada = new Thread(() -> {printNum("A");});
        Thread threadb = new Thread(() -> {
            try {
                System.out.println("threadb start wait");
                threada.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printNum("B");});
        threada.start();
        threadb.start();
    }
    //两个线程按照指定方式有序交叉运行
    public static void demo2(){
        Object lock = new Object();
        Thread threada = new Thread(() ->{
            synchronized (lock){

                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A1");
                System.out.println("A2");
                System.out.println("A3");
            }
        });
        Thread threadb = new Thread(() ->{
            synchronized (lock){
                System.out.println("B1");
                System.out.println("B2");
                System.out.println("B3");
                lock.notify();
            }
        });
        threada.start();
        threadb.start();
    }
    //四个线程 A B C D，其中 D 要等到 A B C 全执行完毕后才执行，而且 A B C 是同步运行的
    public static void demo3(){
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() ->{
            System.out.println("A  prepare execute...");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A  execute...");
        }).start();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "execute....");
                countDownLatch.countDown();
            }).start();
        }
    }

    private static void printNum(String threadName) {
        int i=0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print: " + i);
        }
    }


    public static void demo4(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread() + "wait");
                try {
                    cyclicBarrier.await();
                }catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "excute");

            }).start();
        }
    }

    public static void demo5(){
        Callable<Integer> call = new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                System.out.println("task start");
                int result = 0;
                for (int i = 0; i < 100; i++) {
                    result += i;
                }
                System.out.println("task end");
                return result;
            }
        };
        FutureTask<Integer> task = new FutureTask<>(call);
        new Thread(task).start();

        try {
            System.out.println("before " + task.get());
            System.out.println(task.get());
            System.out.println("after " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {
        //demo1();
        //demo2();
        //demo3();
        //demo4();
        demo5();
    }


}
