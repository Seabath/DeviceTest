package algo;

import model.Device;

import java.util.Comparator;
import java.util.List;

public class Algo {

  static public List<Device> tri(List<Device> list) {
    if (list == null || list.isEmpty()) {
      return list;
    }

//    while (!list.isEmpty()) {
//      Device tmp = list.get(0);
//      list.remove(tmp);
//      int i = 0;
//      while (i < res.size() && tmp != null && tmp.compareTo(res.get(i)) > 0) {
//        i++;
//      }
//      res.add(i, tmp);
//    }

    list.sort(Comparator.nullsFirst(Device::compareTo));

    return list;
  }
}
