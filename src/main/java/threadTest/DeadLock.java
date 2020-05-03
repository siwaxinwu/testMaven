package threadTest;

/**
 * 演示一段死锁的代码
 * 创建两把锁，互相持有对方所需要的锁，又不释放自己的锁,同时都想去获取对方所持有的锁
 * 没有外力介入，不会打破死锁的局面
 */

public class DeadLock {
    public Object o1 = new Object();
    public Object o2 = new Object();

    public void thread1() throws InterruptedException {
        synchronized (o1) {
            Thread.sleep(5000);
            synchronized (o2) {
                System.out.println("线程1成功拿到两把锁");
            }

        }
    }

    public void thread2() throws InterruptedException {
        synchronized (o2) {
            Thread.sleep(5000);
            synchronized (o1) {
                System.out.println("线程2成功拿到两把锁");
            }

        }
    }

    public static void main(String[] args) {
        String json = "";
        final DeadLock deadLock = new DeadLock();
        new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                       deadLock.thread1();
           } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadLock.thread2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
