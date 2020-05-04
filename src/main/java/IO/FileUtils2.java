package IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils2 {
    /**
     * try- with -resource
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
        }
    }

}
