package leetcode;

import java.io.File;
/*
* 统计文件夹的大小
* */
public class CountFileSize {
    public static void main(String[] args) {
        File file = new File("E:/idea_workspace/test");
        count(file);
        System.out.println(len);

    }

    public static long len = 0;
    public static void count(File file){
        if (null != file && file.exists()) {
            if (file.isFile()) {
                len += file.length();
            }else{
                for (File file1: file.listFiles()) {
                    count(file1);
                }


            }
        }

    }
}
