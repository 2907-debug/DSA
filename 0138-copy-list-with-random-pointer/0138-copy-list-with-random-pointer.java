/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        // If list is empty, nothing to copy
        if (head == null) {
            return null;
        }

        Node temp = head;

        // ---------------- Step 1 ----------------
        // Create a copy of every node and insert it
        // Original: 7 -> 13 -> 11
        // After this:
        // 7 -> 7' -> 13 -> 13' -> 11 -> 11'

        while (temp != null) {

            Node copy = new Node(temp.val);

            // Save the next original node
            Node front = temp.next;

            // Put copy after original
            temp.next = copy;

            // Connect copy back to the original next node
            // (Temporary connection, we'll separate later)
            copy.next = front;

            // Move only to the next ORIGINAL node
            temp = front;
        }

        temp = head;

        // ---------------- Step 2 ----------------
        // Copy the random pointers
        // temp = original node
        // temp.next = copied node
        //
        // Example:
        // 7 -> 7' -> 13 -> 13'
        //
        // If 13.random = 7
        // then 13'.random should become 7'
        //
        // temp.random      -> original random node
        // temp.random.next -> copied random node

        while (temp != null) {

            if (temp.random != null) {

                // temp.random → Original random node
//temp.random.next → Us original random node ki copy
                temp.next.random = temp.random.next;
            }

            // Whether random is null or not,
            // always move to the next ORIGINAL node.
            temp = temp.next.next;
        }

        // ---------------- Step 3 ----------------
        // Separate the original and copied lists

        Node original = head;
        Node copy = head.next;

        // Save copied head because we'll return it later
        Node copyHead = head.next;

        while (original != null) {

            // Restore original list
            // 7 -> 7' -> 13
            // becomes
            // 7 -> 13
            original.next = original.next.next;

            // Connect copied list
            // 7' -> 13 -> 13'
            // becomes
            // 7' -> 13'
            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            // Move both pointers forward
            original = original.next;
            copy = copy.next;
        }

        return copyHead;
    }
}