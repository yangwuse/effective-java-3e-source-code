package effectivejava.chapter3.item10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public enum Color { RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET }

class Test {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
    String s = "hello";
    System.out.println(s.contains("he"));
  }
}
