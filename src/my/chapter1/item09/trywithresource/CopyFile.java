package my.chapter1.item09.trywithresource;

import java.io.*;

/**
 *
 * @author yangWu
 * @date 2021/7/19 10:47 下午
 * @version 1.0
 */
public class CopyFile {
    static final int BUFFER_SIZE = 4 * 1024;
    // try-with-resource 读写文件十分简单
    static void copyFile(String srcPath, String dstPath) throws IOException {
        try (InputStream is = new FileInputStream(srcPath);
             OutputStream os = new FileOutputStream(dstPath)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n = 0;
            while ((n = is.read(buf)) > 0)
                os.write(buf, 0, n);
        }
    }

    public static void main(String[] args) throws IOException {
        String src = "src/my/chapter1/item09/trywithresource/ReadFirstLine.java";
        String dst = "src/my/chapter1/item09/trywithresource/a";
        copyFile(src, dst);
    }
}
