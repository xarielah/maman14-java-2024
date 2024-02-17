public class IntListTwo {
    IntNodeTwo _head, _tail;

    public IntListTwo() {
        _head = null;
        _tail = null;
    }

    // Ariel's methods:

    /**
     * Add a new node to the end of the list.
     * 
     * @param num
     */
    public void addToEnd(int num) {
        // Initialize a new node with the given number.
        IntNodeTwo node = new IntNodeTwo(num);

        // If the list is empty, set the head and tail to the new node.
        if (_head == null) {
            _head = node;
            _tail = node;
        } else {
            // Set the next of the current tail to the new node, and set the previous of the
            // new node to the current tail.
            _tail.setNext(node);
            node.setPrev(_tail);
            _tail = node;
        }
    }

    /**
     * Output a string representation of the list.
     * 
     * @return string representation of the list.
     */
    public String toString() {
        // Initialize a string to hold the output.
        String s = "";

        // Initialize a temporary node to the head of the list,
        // we will use it to iterate through the list.
        IntNodeTwo temp = _head;

        // Iterate through the list while temp is not null.
        while (temp != null) {
            // Add the current value to the string,
            // and move temp to the next node.
            s = s + temp.getNum();
            temp = temp.getNext();

            // If next temp is not null, add a comma and a space to the string.
            if (temp != null)
                s += ", ";
        }

        // Return the string wrapped with curly braces.
        return wrapWithCurlyBraces(s);
    }

    private String wrapWithCurlyBraces(String str) {
        return "{" + str + "}";
    }

    /**
     * Output a reversed string representation of the list.
     * 
     * @return revese string representation of the list.
     */
    public String toStringReverse() {
        return wrapWithCurlyBraces(toStringReverse("", _tail));
    }

    private String toStringReverse(String str, IntNodeTwo node) {
        // If the node is null, it means that we've reached a step beyond the head,
        // then return the string.
        if (node == null)
            return str;

        // Add the current value to the string.
        str += node.getNum();

        // If the previous node is not null, add a comma and a space to the string.
        if (node.getPrev() != null)
            str += ", ";

        // Recursive call to the previous node.
        return toStringReverse(str, node.getPrev());
    }

    /**
     * Checks if there is a way in the list from the head to the tail,
     * by steping the list guided by nodes values.
     * 
     * @return boolean
     */
    public boolean isWay() {
        return isWay(_head);
    }

    private boolean isWay(IntNodeTwo node) {
        // If the node is null, it means that we've crossed the boundires of the list,
        // therefore we return false.
        if (node == null)
            return false;

        // If the node is the tail, it means that we've reached the end of the list,
        // therefore we return true.
        if (node == _tail)
            return true;

        // We save in memory the number of the current node.
        int steps = node.getNum();

        // We check if this is already a step we've taken, if so, we return false.
        if (steps == 0)
            return false;

        // If this is a "fresh" step, we'd mark it as a "used" step by zaroing it.
        node.setNum(0);

        // We implement a backtrack here by doing "or" on each step, right first,
        // then left, if we find a way, the isWay method will return true return true.
        return isWay(step(node, steps)) || isWay(step(node, -steps));
    }

    private IntNodeTwo step(IntNodeTwo node, int steps) {
        // If node is null, meaning we exceded the boundaries of the list, we return
        // null.
        if (node == null) {
            return null;
        }

        // If steps is 0, meaning we've reached the node we wanted to reach, we return
        // it.
        if (steps == 0) {
            return node;
        }

        // If steps is positive, we move to the next node, if steps is negative, we move
        // to the previous node.
        if (steps < 0)
            return step(node.getPrev(), steps + 1);

        return step(node.getNext(), steps - 1);
    }
}