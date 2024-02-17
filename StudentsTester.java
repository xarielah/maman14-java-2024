
/**
 * Write a description of class StudentsTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentsTester {
    public static void main(String[] args) {
        IntList l1 = new IntList();
        boolean b1 = l1.subListSum(1);
        IntNode n1 = l1.averageNode();

        IntListTwo l2 = new IntListTwo();

        if (l2.toString().indexOf('@') != -1)
            System.out.println(
                    "You didn't write the method toString in the class IntListTwo\n" +
                            "(or gave it a wrong name.)\n" +
                            "============================\n");
        l2.addToEnd(1);
        String s1 = l2.toStringReverse();
        boolean b2 = l2.isWay();
        System.out.println(
                "\nIf you see this message,\n" +
                        "it means your software worked fine with this tester,\n" +
                        "which only means you wrote all the expected methods\n" +
                        "with the right interface.\n" +
                        "It DOES NOT MEAN your software does exactly what it is\n" +
                        "expected to do.\n" +
                        "To check that, you will have to write your own tester\n" +
                        "which must include all sorts of scenarios.\n" +
                        "The bugs your tester doesn't find - will be found\n" +
                        "by your instructor's tester, and will cost you\n" +
                        "points in your grade.");
    }
}
