package effectivejava.chapter2.item9.tryfinally;

import java.awt.event.InputEvent;
import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 8 * 1024;

    // try-finally is ugly when used with more than one resource! (Page 34)
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}

// test code
class Test {
    private static final int BUFFER_SIZE = 4 * 1024;

    public static void copy(String str, String dst) throws IOException {
        InputStream in = new FileInputStream(str);
        try {
            OutputStream out = new FileOutputStream(dst);
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
            out.close();
        } finally {
            in.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String src = "/Users/yangwu/IdeaProjects/effective-java-3e-source-code/src/effectivejava/chapter2/item9/tryfinally/Copy.java";
        String dst = "Copy.txt";
        copy(src, dst);
    }
}