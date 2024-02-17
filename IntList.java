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

            // If the current value is equal to the target number, return true.
            if (p.getValue() == num)
                return true;

            // If the sum is equal to the target number, return true.
            if (sum == num)
                return true;

            // Move the p pointer to the next node in the list.
            p = p.getNext();
        }

        // If no sublist was found, return false.
        return false;
    }

    /**
     * Space complexity is O(1) and time complexity is O(n).
     * I use here two while loops, since they're separate, each loop is
     * O(n), so the time complexity is O(2n) and we drop constants, therefore time
     * complexity is O(n).
     * 
     * Space complexity is O(1) because I'm using only a few constant variables,
     * that does not change with greater / smaller input.
     * 
     * @return IntNode
     */
    public IntNode averageNode() {
        // If list is empty or has only one element, return null.
        if (_head == null || _head.getNext() == null)
            return null;

        // Initialize max as the head of the list.
        IntNode max = _head;

        // Initialize avg1 and avg2 as 0, this will be used to calculate each
        // part of the separated sublists.
        double avg1 = 0, avg2 = 0;

        // Initialize maxAvg as the minimum value of a double.
        double maxAvg = Double.MIN_VALUE;

        // Initialize len and count as 0, this will be used to calculate the length
        // of the list and the count of he deep we are into the list.
        int len = 0, count = 0;

        // Initialize sum, sum1 and sum2 as 0, this will be used to calculate the sum
        // of the list, and the sum of each sublist.
        int sum = 0, sum1 = 0, sum2 = 0;

        // Initialize a current pointer to the head of the list,
        // this will be used to iterate through the list to sum the values.
        IntNode cur = _head;

        // While loop to initialize the sum and the length of the list.
        // this operation is O(n).
        while (cur != null) {
            len++;
            sum += cur.getValue();
            cur = cur.getNext();
        }

        // Reset the current pointer to the head of the list.
        cur = _head;

        // While loop to iterate through the list and calculate the average of each
        // sublist. This operation is O(n).
        while (cur != null) {
            // Increment the count by 1.
            count++;

            // Add the current value to sum1, and calculate the average of the first
            // sublist by dividing the sum1 by the count.
            sum1 += cur.getValue();
            avg1 = (double) sum1 / count;

            // Calculate the sum2 by subtracting the sum1 from the sum, and calculate the
            // average of the second sublist by dividing the sum2 by the length of the list
            // minus the count.
            sum2 = sum - sum1;
            avg2 = (double) sum2 / (len - count);

            // If the absolute difference between avg1 and avg2 is greater than the maxAvg,
            // set max as the current node and maxAvg as the absolute difference between
            // avg1 and avg2.
            if (maxAvg < Math.abs(avg1 - avg2)) {
                max = cur;
                maxAvg = Math.abs(avg1 - avg2);
            }

            // Move the current pointer to the next node in the list.
            cur = cur.getNext();
        }

        // Return the max node.
        return max;
    }
}