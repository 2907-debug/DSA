/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // reverse a single linked list
    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            // save next node
            ListNode front = curr.next;

            // reverse current link
            curr.next = prev;

            // move pointers
            prev = curr;
            curr = front;
        }

        // prev becomes the new head
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        // nothing to reverse
        if (head == null || k == 1)
            return head;

        // start of current group
        ListNode temp = head;

        // tail of previously reversed group
        ListNode prevLast = null;

        while (temp != null) {

            // find kth node of current group
            ListNode kth = temp;

            for (int i = 1; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // less than k nodes left
            if (kth == null) {

                // attach remaining nodes as it is
                if (prevLast != null) {
                    prevLast.next = temp;
                }

                break;
            }

            // save next group's starting node
            ListNode nextGroup = kth.next;

            // cut current group
            kth.next = null;

            // reverse current group
            ListNode newHead = reverse(temp);

            // first group updates overall head
            if (prevLast == null) {
                head = newHead;
            } else {

                // connect previous group with current group
                prevLast.next = newHead;
            }

            // temp was first before reverse
            // now it becomes the tail
            prevLast = temp;

            // move to next group
            temp = nextGroup;
        }

        return head;
    }
}