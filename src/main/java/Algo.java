import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algo {

    static public List<Device> tri(List<Device> list) {
        if (list == null || list.isEmpty())
            return list;

        List<Device> res = new ArrayList<Device>();
        while (!list.isEmpty()) {
            Device tmp = list.get(0);
            list.remove(tmp);
            int i = 0;
            while (i < res.size() && compareDevice(tmp, res.get(i)) < 0) {
                i++;
            }
            res.add(i, tmp);
        }
        return res;
    }


    static public int compareDevice(Device dev1, Device dev2) {
        if (dev1 == null && dev2 == null)
            return 0;
        if (dev1 == null)
            return -1;
        if (dev2 == null)
            return 1;

        String[] tabDev1 = dev1.getVersion().split("\\.");
        List<String> listDev1 = removeZero((ArrayList<String>) Arrays.asList(tabDev1));


        String[] tabDev2 = dev2.getVersion().split("\\.");
        List<String> listDev2 = removeZero((ArrayList<String>) Arrays.asList(tabDev2));

        int i = 0;
        while (i < listDev1.size() - 1 && i < listDev2.size() - 1 && listDev1.get(i).compareTo(listDev2.get(i)) == 0)
            i++;

        if (listDev1.get(i).compareTo(listDev2.get(i)) == 0 && listDev1.size() != listDev2.size())
            return listDev1.size() - listDev2.size();

        return listDev1.get(i).compareTo(listDev2.get(i));
    }

    static public List<String> removeZero(ArrayList<String> list) {
        if (list == null)
            return null;
        int i = list.size() - 1;
        while (i > 0 && list.get(i).compareTo("0") == 0) {
            list.remove(i--);
        }

        return list;
    }
}
