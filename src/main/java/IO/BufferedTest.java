package IO;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) {
        //1、创建源
        File src = new File("src/main/abc.txt");
        //2、选择流
        BufferedReader  reader =null;
        try {
            reader =new BufferedReader(new FileReader(src));
            //3、操作 (分段读取)
            String line =null;
            while((line=reader.readLine())!=null) {
                //字符数组-->字符串
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、释放资源
            try {
                if(null!=reader) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
