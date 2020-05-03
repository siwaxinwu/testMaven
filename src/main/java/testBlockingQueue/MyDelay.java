package testBlockingQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/*
* 自定义延迟队列
*
* */
public class MyDelay implements Delayed {
    long delayTime = System.currentTimeMillis();
    private String msg;


    public MyDelay(long delayTime, String msg) {
        this.delayTime += delayTime;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MyDelay{" +
                "delayTime=" + delayTime +
                ", msg='" + msg + '\'' +
                '}';
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delayTime - System.currentTimeMillis(),
                TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        }else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)){
            return -1;
        }else {
            return 0;
        }

    }
}
