import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class IntListTwoTester {
    @Test
    public void testAddToEnd() {
        IntListTwo list = new IntListTwo();
        list.addToEnd(3);
        list.addToEnd(6);
        list.addToEnd(2);
        list.addToEnd(7);
        list.addToEnd(1);
        System.out.println(list.toString());
        System.out.println(list.toStringReverse());
    }

    @Test
    public void toStringTest() {
        IntListTwo list = new IntListTwo();
        list.addToEnd(5);
        list.addToEnd(4);
        list.addToEnd(6);
        list.addToEnd(2);
        list.addToEnd(9);
        list.addToEnd(7);
        list.addToEnd(8);

        assertEquals("{5, 4, 6, 2, 9, 7, 8}", list.toString());

        IntListTwo list2 = new IntListTwo();
        assertEquals("{}", list2.toString());
    }

    @Test
    public void toReverseStringTest() {
        IntListTwo list = new IntListTwo();
        list.addToEnd(5);
        list.addToEnd(4);
        list.addToEnd(6);
        list.addToEnd(2);
        list.addToEnd(9);
        list.addToEnd(7);
        list.addToEnd(8);

        assertEquals("{8, 7, 9, 2, 6, 4, 5}", list.toStringReverse());

        IntListTwo list2 = new IntListTwo();
        assertEquals("{}", list2.toStringReverse());
    }

    @Test
    public void testIsWay() {
        IntListTwo l1 = new IntListTwo();

        l1.addToEnd(2);
        l1.addToEnd(1);
        l1.addToEnd(3);

        assertEquals(true, l1.isWay());

        IntListTwo l2 = new IntListTwo();
        l2.addToEnd(2);
        l2.addToEnd(4);
        l2.addToEnd(1);
        l2.addToEnd(6);
        l2.addToEnd(4);
        l2.addToEnd(2);
        l2.addToEnd(4);
        l2.addToEnd(3);
        l2.addToEnd(5);

        assertEquals(true, l2.isWay());

        IntListTwo l3 = new IntListTwo();
        l3.addToEnd(1);
        l3.addToEnd(4);
        l3.addToEnd(3);
        l3.addToEnd(1);
        l3.addToEnd(2);
        l3.addToEnd(4);
        l3.addToEnd(3);

        assertEquals(false, l3.isWay());
    }
}
