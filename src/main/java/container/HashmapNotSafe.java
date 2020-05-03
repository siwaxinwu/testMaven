package container;

import java.security.Key;
import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * hashmap不是线程安全的，如果在while循环打断点等待一会，那么就不会抛出异常
 * 如果不打断点，就会抛出异常
 */
public class HashmapNotSafe {
    public static void main(String[] args) {
        final HashMap<Integer, String> map = new HashMap<>();
        final Integer targetKey = 65535;
        final  String targetValue = "v";
        map.put(targetKey, targetValue);
        new Thread(() -> {
            IntStream.range(0, targetKey).forEach(Key -> map.put(Key, "someValue"));

        }).start();
        while (true){
            if (null == map.get(targetKey)){
                throw new RuntimeException("hashmap is not safe");
            }
        }

    }
}
