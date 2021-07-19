package my.chapter1.item09.tryfinally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 避免使用 try finally 读文件
 * @author yangWu
 * @date 2021/7/18 8:42 下午
 * @version 1.0
 */
public class ReadLine {
    static String readFirstLine(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        // 必须是可选路径：绝对路径、项目根路径
        String path = "src/my/chapter1/item09/tryfinally/ReadLine.java";
        System.out.println(readFirstLine(path));
    }
}
