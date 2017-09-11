import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AlgoTest {


    @Test
    public void NullList() {
        List<Device> res = Algo.tri(null);
        assert res == null;
    }

    @Test
    public void EmptyList() {
        List<Device> res = Algo.tri(new ArrayList<Device>());
        assert res.isEmpty();
    }

    @Test
    public void SimpleList() {
        ArrayList<Device> test = new ArrayList<Device>();
        test.add(new Device("a", "7.0"));
        test.add(new Device("b", "7"));
        test.add(new Device("b", "6.4.2"));
        List<Device> res = Algo.tri(test);
        assert test.get(0).getVersion().equals("6.4.2");
        assert test.get(1).getVersion().equals("7");
        assert test.get(2).getVersion().equals("7.0");
    }


    @Test
    public void SimpleCompares() {
        assert Algo.compareDevice(null, null) == 0;
        assert Algo.compareDevice(null, new Device("bloblo", "1")) < 0;
        assert Algo.compareDevice(new Device("bloblo", "1"), null) > 0;

        //ici les deux versions sont identiques
        Device great = new Device("manger", "7");
        Device low = new Device("manger", "7.0");
        assert Algo.compareDevice(great, low) == 0;
        assert Algo.compareDevice(low, great) == 0;
    }

    @Test
    public void AdvanceCompares() {
        Device great = new Device("manger", "7.1");
        Device low = new Device("manger", "6.4.2");
        assert Algo.compareDevice(great, low) > 0;
        assert Algo.compareDevice(low, great) < 0;

        great = new Device("manger", "7.0.1");
        low = new Device("manger", "7");
        assert Algo.compareDevice(great, low) > 0;
        assert Algo.compareDevice(low, great) < 0;
    }


    @Test
    public void removeZeroTest() {
        assert Algo.removeZero(null) == null;


        ArrayList<String> test = new ArrayList<String>();
        test.add("7");
        assert Algo.removeZero(test).size() == 1;

        test.add("0");
        assert Algo.removeZero(test).size() == 1;

        test.add("0");
        test.add("1");
        assert Algo.removeZero(test).size() == 3;
    }
}
