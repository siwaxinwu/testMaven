package threadTest;

import java.util.HashMap;
import java.util.Map;

/**
 * 线程的启动是需要一定时间的，在main函数中，new对象以后，直接调用会报空指针的
 *
 */
public class WrongInit {
    private Map<Integer, String> students;
    public WrongInit(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                students = new HashMap<Integer, String>();
                students.put(1, "yawu");
                students.put(2, "pengfei");
                students.put(3, "chunhua");

            }
        }

        ).start();
    }

    public Map<Integer, String> getStudents(){
        return students;
    }

    public static void main(String[] args) {
        WrongInit wrongInit = new WrongInit();
        System.out.println(wrongInit.students.get(1));
    }
}
