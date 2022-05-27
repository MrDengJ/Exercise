package java.CHC5223.partB;

import CHC5223.PartB.AbsListInt;
import CHC5223.PartB.ListInt;
import org.junit.Test;

public class ListIntTest {
    private AbsListInt listInt = new ListInt(5);

    @Test
    public void test1() {
        for (int i = 1; i <= 5; i++) {
            listInt.append(i);
        }
        System.out.println(listInt.getSize());
        for (int i = 1; i <= 5; i++) {
            boolean contains = listInt.contains(i);
            System.out.println(contains);
        }
    }
}
