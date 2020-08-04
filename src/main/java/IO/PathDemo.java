package IO;



import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

//建议大家用path1和path2
public class PathDemo {
    public static void main(String[] args) {
        String path = "E:\\idea_workspace\\test\\linux.png";
        System.out.println(File.separatorChar);
        System.out.println(File.separator);
        System.out.println( "path   " + path);
        String path1 = "E:/idea_workspace/test/linux.png";
        System.out.println("path1    " + path1);
        String path2 = "E:" + File.separator +"idea_workspace" + File.separator +
                "test" + File.separator + "linux.png";
        System.out.println(path2);
    }

    @Test
    public void test(){
        String path1 = "E:/idea_workspace/test/linux.png";
        File file = new File(path1);
        System.out.println(file.length());
    }
/*
    存在盘符是绝对路径，没有看见盘符就是相对路径，没有盘符以"user.dir"作为相对路径
    getPath（）构建的时候是什么路径，返回的就是什么路径
*/
    @Test
    public void test1(){
        String path1 = "E:/idea_workspace/test/linux.png";
        File file = new File(path1);
        System.out.println(file.getAbsolutePath());
        File file1 = new File("linux.png");
        System.out.println(file1.getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
    }
    //File允许构建一个不存在的文件夹
    @Test
    public void test2(){
        String path1 = "E:/idea_workspace/test/aaa/linux.png";
        File file1 = new File(path1);
        System.out.println(file1.getAbsolutePath());
    }
/*getParent():获取父路径
*
* */
    @Test
    public void test3(){
        String path1 = "E:/idea_workspace/test/linux.png";
        File file = new File(path1);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());
        System.out.println(file.getParentFile().getAbsolutePath());
    }

    @Test
    public void test4(){
        String path = "E:/idea_workspace/test/linux.png";
        File file = new File(path);
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println("----------------");
        String path1 = "E:/idea_workspace/test";
        File file1 = new File(path1);
        System.out.println(file1.exists());
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());
        System.out.println("----------------");
        //文件状态的标准代码
        File xxx = new File("xxx");
        if (null == xxx || !xxx.exists()) {
            System.out.println("文件不存在，包括文件夹和文件");
        }else if (xxx.isFile()){
            System.out.println("文件操作");
        }else if (xxx.isDirectory()) {
            System.out.println("文件夹操作");
        }
    }

/*
* createNewFile():不存在就创建，存在创建成功
 * delete():
*
* */

    @Test
    public void test5() throws IOException {
        String path = "E:/idea_workspace/test/linux.png";
        File file = new File(path);
        System.out.println(file.length());
        System.out.println("------------------------------------------");
        String path1 = "E:/idea_workspace/test";
        File file1 = new File(path1);
        System.out.println(file1.length());

        System.out.println("------------------------------------------");
        String path2 = "E:/idea_workspace/testxxxx";
        File file2 = new File(path2);
        System.out.println(file2.length());

        System.out.println("------------------------------------------");
        String path3 = "E:/idea_workspace/test/io.txt";
        File file3 = new File(path3);
        boolean flag = file3.createNewFile();
        System.out.println(flag);
        boolean delete = file3.delete();
        System.out.println(delete);
    }
/*
* mkdir()必须保证上一级目录存在，否则创建失败
* mkdirs（）上级目录可以不存在，一同创建
* 开发过程中推荐使用mkdirs
* */
    @Test
    public void dirDemo() throws IOException {
        String path = "E:/idea_workspace/test/dir1/dir2";
        File file = new File(path);
        boolean flag = file.mkdir();
        System.out.println("创建文件夹是否成功" + flag);
        System.out.println("------------------------------------------");
        String path1 = "E:/idea_workspace/test";
        File file1 = new File(path1);
        String[] list = file1.list();
        System.out.println("列出test下的文件和文件夹名称" + Arrays.toString(list));
        System.out.println("------------------------------------------");
        File[] files = file1.listFiles();
        for (File file2 : files) {
            System.out.println("test文件下文件的文件夹的目录" + file2.getAbsolutePath());
        }
        System.out.println("------------------------------------------");
    }

    @Test
    public void contentEncode() throws IOException {
        String name = "dingyawu";
        byte[] bytes = name.getBytes();//默认使用工程的字符集
        System.out.println(bytes.length);
        byte[] bytes1 = name.getBytes("utf-8");//编码成别的字符集
        System.out.println(bytes1.length);
        String s = new String(bytes, "GBK");
        System.out.println(s);
        //乱码的原因:字节数不够,字符集不统一


    }

}
