import static util.Util.containsOnly;
import static util.Util.removeZero;

import algo.Algo;
import model.Device;
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
  public void FullNullList() {
    ArrayList<Device> test = new ArrayList<Device>();
    test.add(null);
    test.add(null);
    test.add(null);
    List<Device> res = Algo.tri(test);
    assert res.get(0) == null;
    assert res.get(1) == null;
    assert res.get(2) == null;
  }

  @Test
  public void SimpleList() {
    ArrayList<Device> test = new ArrayList<Device>();
    test.add(new Device("a", "7.00"));
    test.add(new Device("b", "7"));
    test.add(new Device("b", "6.4.2"));
    List<Device> res = Algo.tri(test);
    assert res.get(0).getVersion().equals("6.4.2");
    assert res.get(1).getVersion().equals("7");
    assert res.get(2).getVersion().equals("7");
  }


  @Test
  public void SimpleCompares() {
    assert new Device("bloblo", "1").compareTo(null) > 0;

    //ici les deux versions sont identiques
    Device great = new Device("manger", "7");
    Device low = new Device("manger", "7.00");
    assert great.compareTo(low) == 0;
    assert low.compareTo(great) == 0;
  }

  @Test
  public void AdvanceCompares() {
    Device great = new Device("manger", "7.1");
    Device low = new Device("manger", "6.4.2");
    assert great.compareTo(low) > 0;
    assert low.compareTo(great) < 0;

    great = new Device("manger", "7.0.1");
    low = new Device("manger", "7");
    assert great.compareTo(low) > 0;
    assert low.compareTo(great) < 0;
  }


  @Test
  public void removeZeroTest() {
    assert removeZero((String) null).isEmpty();
    assert removeZero(new ArrayList<>()).isEmpty();

    ArrayList<String> test = new ArrayList<>();
    test.add("7");
    assert removeZero(test).size() == 1;

    test.add("0");
    assert removeZero(test).size() == 1;

    test.add("0");
    test.add("1");
    assert removeZero(test).size() == 3;
  }

  @Test
  public void containsOnlyTest() {
    assert !containsOnly(null, '0');
    assert containsOnly("0", '0');
    assert containsOnly("00000", '0');
    assert !containsOnly("10", '0');
    assert !containsOnly("01", '0');
  }
}