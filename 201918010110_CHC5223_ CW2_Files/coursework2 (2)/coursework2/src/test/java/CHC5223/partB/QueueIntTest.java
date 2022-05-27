package java.CHC5223.partB;

import CHC5223.PartB.AbsQueueInt;
import CHC5223.PartB.QueueInt;
import org.junit.Test;

public class QueueIntTest {
    private AbsQueueInt queueInt = new QueueInt(5);
    @Test
    public void test() {
        queueInt.addToBack(4);
        queueInt.addToBack(1);
        queueInt.addToBack(2);
        System.out.println(queueInt.getSize());
        int i = queueInt.removefromFront();
        System.out.println(i);
        System.out.println(queueInt.getSize());

    }
}
