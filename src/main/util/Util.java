package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {

  static public String removeZeroString(String version) {
    if (version == null) {
      return null;
    }
    return removeZero(version).stream()
        .map(s -> s.concat("."))
        .collect(Collectors.joining())
        .replaceFirst(".$", "");
  }

  static public List<String> removeZero(String version) {
    if (version == null) {
      return new ArrayList<>();
    }
    String[] tabVersion = version.split("\\.");
    return removeZero(new ArrayList<>(Arrays.asList(tabVersion)));
  }

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
