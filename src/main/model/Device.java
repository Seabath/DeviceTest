package model;

import static util.Util.removeZeroString;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

public class Device {

  @Getter
  @Setter
  String name;
  @Getter
  @Setter
  String version;

  public Device(String mName, String mVersion) {
    this.name = mName;
    this.version = removeZeroString(mVersion);
  }

  public int compareTo(Device dev2) {
    if (dev2 == null)
      return 1;

    String[] tabDev1 = this.version.split("\\.");
    List<String> listDev1 = Arrays.asList(tabDev1);


    String[] tabDev2 = dev2.getVersion().split("\\.");
    List<String> listDev2 = Arrays.asList(tabDev2);

    int i = 0;
    while (i < listDev1.size() - 1 && i < listDev2.size() - 1 && listDev1.get(i).compareTo(listDev2.get(i)) == 0) {
      i++;
    }

    if (listDev1.get(i).compareTo(listDev2.get(i)) == 0 && listDev1.size() != listDev2.size()) {
      return listDev1.size() - listDev2.size();
    }

    return listDev1.get(i).compareTo(listDev2.get(i));
  }
}
