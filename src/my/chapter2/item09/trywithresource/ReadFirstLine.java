package my.chapter2.item09.trywithresource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author yangWu
 * @date 2021/7/19 10:40 下午
 * @version 1.0
 */
public class ReadFirstLine {
    // 使用 try with resource 读取关闭资源
    static String readFirstLine(String srcPath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(srcPath))) {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        String src = "src/my/chapter1/item09/trywithresource/ReadFirstLine.java";
        System.out.println(readFirstLine(src));
    }
}
