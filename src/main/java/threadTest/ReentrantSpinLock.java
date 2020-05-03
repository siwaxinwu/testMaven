package threadTest;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 实现一个可重入的自旋锁
 */
public class ReentrantSpinLock {
    private AtomicReference<Thread> owner = new AtomicReference<>();
    //重入次数
    private int count = 0;
    private void lock(){
        Thread thread = Thread.currentThread();
        if (thread == owner.get()){
            ++ count;
            return;
        }
        while (!owner.compareAndSet(null, thread)){
            System.out.println("自旋了");
        }
    }

    private void unlock(){
        Thread thread = Thread.currentThread();
        if (thread == owner.get()){
            if (count > 0){
                -- count;
            } else {
                owner.set(null);
            }
        }
        while (!owner.compareAndSet(null, thread)){

        }
    }

    public static void main(String[] args) {
        ReentrantSpinLock lock = new ReentrantSpinLock();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "开始尝试获取自旋锁");
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "获得了自旋锁");
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + "释放了自旋锁");
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
