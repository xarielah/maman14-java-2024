import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntListTester {
    @Test
    public void testSubListSum() {
        IntList list = new IntList();
        list.addToEnd(3);
        list.addToEnd(6);
        list.addToEnd(2);
        list.addToEnd(7);
        list.addToEnd(1);

        assertEquals(true, list.subListSum(15));
        assertEquals(true, list.subListSum(16));
        assertEquals(true, list.subListSum(11));
        assertEquals(true, list.subListSum(10));
        assertEquals(false, list.subListSum(-100000));
        assertEquals(false, list.subListSum(99999));
        assertEquals(false, list.subListSum(14));
    }
}
