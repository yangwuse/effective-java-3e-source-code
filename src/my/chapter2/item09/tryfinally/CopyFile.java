package my.chapter2.item09.tryfinally;

import java.io.*;

/**
 * 避免使用 try finally
 * @author yangWu
 * @date 2021/7/19 10:23 下午
 * @version 1.0
 */
public class CopyFile {
    static final int BUFFER_SIZE = 4 * 1024;
    // 使用多个资源会导致嵌套 try finally
    static void copyFile(String src, String dst) throws IOException {
        InputStream is = new FileInputStream(src);
        try {
            OutputStream os = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n = 0;
                while ((n = is.read(buf)) > 0)
                    os.write(buf, 0, n);
            } finally {
                os.close();
            }
        } finally {
           is.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String src = "src/my/chapter1/item09/tryfinally/CopyFile.java";
        String dst = "src/my/chapter1/item09/tryfinally/a.java";
        copyFile(src, dst);
    }
}
