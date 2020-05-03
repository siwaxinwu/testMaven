package threadTest;

/**
 * 线程安全主要就是三类问题
 * 错误的结果、活跃性问题、发布和初始化线程安全问题
 * 活跃性问题：活锁、死锁、饥饿
 * 饥饿是指某些线程一直得不到锁导致不能运行
 * 活锁是指线程重复去运行一个错误逻辑
 *
 */
public class WrongResult {
    public static int i;

    public static void main(String[] args) throws InterruptedException {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
        Runnable runnable = new Runnable() {

            public void run() {
                for (int j = 0; j < 10000; j++) {
                    WrongResult.i++;
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println("game over" + WrongResult.i);
    }




}
