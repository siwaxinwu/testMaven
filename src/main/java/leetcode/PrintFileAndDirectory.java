package leetcode;

import java.io.File;
/*
* 打印子孙级目录和文件的名称
* */
public class PrintFileAndDirectory {
    public static void main(String[] args) {
        File file = new File("E:/idea_workspace/test");
        printname(file, 0);

    }
    public static void printname(File file, int deep){
        //控制打印层次感，递归头和递归体
        for (int i = 0; i < deep; i++) {
            System.out.print("-");
        }
        System.out.println(file.getName());
        if (null == file || !file.exists()) {
            return;
        }else if (file.isDirectory()){
            for (File file1: file.listFiles()) {
                printname(file1,deep + 1);
            }
        }


    }
}
