package IO;



import org.junit.jupiter.api.Test;


import java.io.*;

/*
*
* */
public class IOTest {
    @Test
    public void test01()  {
        File file = new File("io.txt");
        try {
            InputStream fis = new FileInputStream(file);
            int data1 = fis.read();
            int data2 = fis.read();
            int data3 = fis.read();
            System.out.println("data1:" + (char)data1 + " data2:" + (char)data2 + " data3:" + (char)data3);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Test
    public void test02() {
        File file = new File("io.txt");
        InputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int tmp = 0;
            while ((tmp = fis.read())!= -1){
                System.out.println((char) tmp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != fis){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //创建源、选择流、分段读取

    public void test03() {
        File file = new File("io.txt");
        InputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] bytes = new byte[50];//缓冲容器
            int len = -1;//接受长度
            while ((len = fis.read(bytes)) != -1){
                System.out.println(new String(bytes,0, len));//字节数组到字符串，解码
                System.out.println(new String(bytes));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
//文件字节输出流，创建源、选择流、操作写出内容、释放资源
    @Test
    public void test04() {
        File file = new File("dest.txt");//这个文件本来不存在的，注意看路径
        InputStream fis = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file, true);//文件后面追加
            String msg = "my name is huangcaifeng";
            byte[] bytes = msg.getBytes();//编码，字符串到字节数组
            fos.write(bytes, 0, bytes.length);
            fos.flush();//刷新此输出流并强制任何缓冲的的输出字节被写出
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test(){
        fileCopy("src/main/java/IO/PathDemo.java", "io.txt");
    }



/*
*
* 文件拷贝
* 思考用递归制作文件夹的拷贝
*
* */
    public static void fileCopy(String srcPath, String destPath) {

        File src = new File(srcPath);
        File dest = new File(destPath);//这个文件本来不存在的，注意看路径
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            byte[] bytes = new byte[1024];
            int tmp = -1;
            while ((tmp = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, bytes.length);
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //先打开的后关闭
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test06(){
        File file = new File("io.txt");
        Reader reader = null;
        try {
             reader = new FileReader(file);
            char[] chars = new char[1024];
            int len = -1;
            while ((len = reader.read(chars)) != -1){
                String s = new String(chars, 0, len);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test07() {
        File file = new File("dest.txt");//这个文件本来不存在的，注意看路径
        InputStream fis = null;
        FileWriter fos = null;
        try {
            fos = new FileWriter(file);//文件后面追加
            String msg = "my name is huangcaifeng";
            /*char[] datas = msg.toCharArray();//编码，字符串到字节数组
            fos.write(datas, 0, datas.length);*/
            /*fos.write(msg);
            fos.flush();//刷新此输出流并强制任何缓冲的的输出字节被写出*/
            fos.append(msg).append("are you ok");
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test08() {
        String msg = "talk is cheap show me the code";
        byte[] src = msg.getBytes();
        InputStream fis = null;
        try {
            fis = new ByteArrayInputStream(src);//文件后面追加
            byte[] flush = new byte[5];
            int len = -1;
            while ((len = fis.read(flush)) != -1) {
                String s = new String(flush, 0, len);
                System.out.println(s);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test09() {
        File file = new File("dest.txt");//这个文件本来不存在的，注意看路径
        InputStream fis = null;
        FileWriter fos = null;
        try {
            fos = new FileWriter(file);//文件后面追加
            String msg = "my name is huangcaifeng";
            /*char[] datas = msg.toCharArray();//编码，字符串到字节数组
=            /*fos.write(msg);
            fos.flush();//刷新此输出流并强制任何缓冲的的输出字节被写出*/
            fos.append(msg).append("are you ok");
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
