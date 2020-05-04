package IO;

import java.io.*;

public class FileUtils {
    /**
     * 对接输入输出流
     * @param is
     * @param os
     */
    public static void fileCopy(InputStream is, OutputStream os) {
        try {
            byte[] bytes = new byte[1024];
            int tmp = -1;
            while ((tmp = is.read(bytes)) != -1) {
                os.write(bytes, 0, bytes.length);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //先打开的后关闭
            close(is, os);

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = new FileInputStream("java.txt");
        OutputStream os = new FileOutputStream("java-copy.txt");
        fileCopy(is, os);
    }

    /**
     * 释放资源
     * @param is
     * @param os
     */
    public static void close(InputStream is, OutputStream os){
        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 释放资源
     * @param ios
     */
    public static void close(Closeable... ios){
        for (Closeable io: ios) {
            if (null != io) {
                try {
                    io.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
