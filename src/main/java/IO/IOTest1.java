package IO;

import java.io.*;

public class IOTest1 {
    //图片到程序fileinputStream、程序到字节数组ByteArrayOutputStream
    public static byte[] fileToByteArray(String filePath){
        File file = new File(filePath);
        InputStream is = null;
        Byte[] dest = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(file);
            byte[] flush = new byte[1024*10];
            int len = -1;
            while ((len = is.read(flush)) != -1){
                baos.write(flush, 0, len);//写出到字节数组中
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
