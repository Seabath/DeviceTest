package util;

import java.util.List;
import java.util.stream.IntStream;

public class Util {
  static public List<String> removeZero(List<String> list) {
    if (list == null || list.isEmpty()) {
      return list;
    }

    for (int i = list.size() - 1; i > 0 && containsOnly(list.get(i), '0'); i--) {
      list.remove(i);
    }

    return list;
  }

  public static boolean containsOnly(String s, char c) {
    return s != null &&
        IntStream
            .range(0, s.length())
            .noneMatch(i -> s.charAt(i) != c);
  }
}
