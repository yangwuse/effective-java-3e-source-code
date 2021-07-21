package my.chapter1.item09.trywithresource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author yangWu
 * @date 2021/7/19 10:44 下午
 * @version 1.0
 */
public class ReadFirstLineWithDefault {
    static String readFirstLine(String srcPath, String defaultVal) {
        try (BufferedReader bf = new BufferedReader(new FileReader(srcPath))) {
            return bf.readLine();
        } catch (IOException e) {
           return defaultVal;
        }
    }

    public static void main(String[] args) {
        String src = "src/my/chapter1/item09/trywithresource/ReadFirstLine";
        System.out.println(readFirstLine(src, "no such file"));
    }
}
