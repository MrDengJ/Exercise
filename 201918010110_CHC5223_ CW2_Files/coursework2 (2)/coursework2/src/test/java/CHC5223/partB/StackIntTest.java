package java.CHC5223.partB;

import CHC5223.PartB.AbsStackInt;
import CHC5223.PartB.StackInt;

import org.junit.Test;

public class StackIntTest {
    private final AbsStackInt stackInt = new StackInt(5);

    @Test
    public void test() {
        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);
        stackInt.push(4);
        stackInt.push(5);
        while (stackInt.getSize() != 0) {
            System.out.print(stackInt.pop() + " ");
        }

        System.out.println();
        stackInt.push(2);
        stackInt.push(3);
        stackInt.push(4);
        System.out.println(stackInt.getSize());
        System.out.println(stackInt.peek());
        stackInt.pop();
        System.out.println(stackInt.getSize());
        stackInt.pop();
        System.out.println(stackInt.peek());
        System.out.println(stackInt.getSize());
    }
}
