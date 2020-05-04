/*
package IO;

import org.junit.jupiter.api.Test;

import java.io.*;

public class BufferedTest {
    @Test
    public static void testBufferedInputStream() {
        //1、创建源
        File src = new File("abc.txt");
        //2、选择流
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(src));
            //3、操作 (分段读取)
            byte[] flush = new byte[1024];
            int len = -1;
            while((len=is.read(flush))!=-1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、释放资源
            try {
                if(null!=is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public static void testBufferedOutputStream() {
        //1、创建源
        File src = new File("abc.txt");
        //2、选择流
       OutputStream is = null;
        try {
            is = new BufferedOutputStream(new FileOutputStream(src));
            String msg = "are you ok";
            while((len=is.read(flush))!=-1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、释放资源
            try {
                if(null!=is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
*/
