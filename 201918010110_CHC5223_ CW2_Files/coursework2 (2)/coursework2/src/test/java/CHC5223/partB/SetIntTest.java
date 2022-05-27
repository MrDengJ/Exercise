package java.CHC5223.partB;

import CHC5223.PartB.AbsSetInt;
import CHC5223.PartB.SetInt;
import org.junit.Test;

public class SetIntTest {
    private AbsSetInt setInt = new SetInt(5);

    @Test
    public void test() {
        setInt.include(1);
        setInt.include(2);
        setInt.include(3);
        setInt.include(4);
        setInt.include(5);
        boolean contains = setInt.contains(3);
        System.out.println(contains);
        System.out.println(setInt.getSize());
        setInt.exclude(2);
        setInt.exclude(1);
        setInt.exclude(1);
        System.out.println(setInt.getSize());
    }
}
