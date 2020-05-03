package leetcode;

import java.io.File;
import java.nio.file.Path;

public class DirCount {

    private long len;
    private String path;
    private File src;
    private int fileSize;
    private int dirSize;

    public long getLen() {
        return len;
    }

    public DirCount(String path){
        this.path = path;
        this.src = new File(path);
        count(src);
    }

    public static void main(String[] args) {
        DirCount dirCount = new DirCount("E:/idea_workspace/test");
        System.out.println(dirCount.getLen());

    }
    private void count(File file){
        if (null != file && file.exists()) {
            if (file.isFile()) {
                len += file.length();
                this.fileSize ++;
            }else{
                this.dirSize ++;
                for (File file1: file.listFiles()) {
                    count(file1);
                }
            }
        }
    }
}
