public class IntList {
    private IntNode _head;

    public IntList() {
        _head = null;
    }

    public void addToEnd(int num) {
        // adds num at the end of the list
        IntNode node = new IntNode(num);
        if (_head == null)
            _head = node;
        else {
            IntNode ptr = _head;
            while (ptr.getNext() != null)
                ptr = ptr.getNext();
            ptr.setNext(node);
        }
    }

    public String toString() {
        String s = "";
        IntNode temp = _head;
        while (temp != null) {
            s = s + temp.getValue() + " --> ";
            temp = temp.getNext();
        }
        s += " null";
        return s;
    }

    // Ariel's methods:

    /**
     * Space complexity is O(1) and time complexity is O(n).
     * 
     * Time complexity is O(n) because we iterate through the list only once, I'm
     * working my way with two pointers, one is the head of the list and the other
     * is the tail of the list and if the sum is greater than the target number,
     * then I'll
     * eliminate the first element in the list and move the tail pointer to the next
     * node.
     * 
     * Spcae complexity is one because I'm using only two pointers, and it doesn't
     * matter weather the input
     * is 10 or 1000, the space complexity will remain the same.
     * 
     * @param num
     * @return boolean
     */
    public boolean subListSum(int num) {
        // Initialize p as the head of the list.
        IntNode p = _head;

        // Initialize tail as the head of the list, in the next loop,
        // we will use tail to progress through the list.
        IntNode tail = p;

        // Initialize a sum variable that will be set to 0 on each iteration.
        int sum = 0;

        // Iterate through the list while p is not null.
        while (p != null) {
            // Add the current value to the sum.
            sum += p.getValue();

            // If the sum is greater than the target number, we will eliminate the first
            // (tail)
            // element in the list and move the tail pointer to the next node.
            if (sum > num) {
                sum -= tail.getValue();
                tail = tail.getNext();
            }

            // If the sum is equal to the target number, return true.
            if (sum == num) {
                return true;
            }

            // Move the p pointer to the next node in the list.
            p = p.getNext();
        }

        // If no sublist was found, return false.
        return false;
    }

    /**
     * Space complexity is O(1) and time complexity is O(n).
     * 
     * @return
     */
    public IntNode averageNode() {
        // If list is empty or has only one element, return null.
        if (_head == null || _head.getNext() == null)
            return null;

        return _head;
    }

    public static void main(String[] args) {
        IntList list = new IntList();
        list.addToEnd(3);
        list.addToEnd(6);
        list.addToEnd(2);
        list.addToEnd(7);
        list.addToEnd(1);

        System.out.println(list.subListSum(5));
    }
}