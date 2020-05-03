package threadPool;

public class VolatileStopThread implements Runnable {
    private volatile boolean cancelled = false;
    @Override
    public void run() {
        int num = 0;
        try {
            while (! cancelled && num <= 1000000) {
                if (num % 10 == 0) {
                    System.out.println(num + "-----10的倍数");
                }
                num ++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        VolatileStopThread r = new VolatileStopThread();
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(1000);
        r.cancelled = true;
    }

}
