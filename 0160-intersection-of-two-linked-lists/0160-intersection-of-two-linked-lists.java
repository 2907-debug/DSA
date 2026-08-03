/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = getLength(headA);
        int lenB = getLength(headB);

        ListNode t1 = headA;
        ListNode t2 = headB;

        // find the difference in length
        int diff = Math.abs(lenA - lenB);

        // move the bigger list ahead
        if (lenA > lenB) {
            while (diff > 0) {
                t1 = t1.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                t2 = t2.next;
                diff--;
            }
        }

        // move both pointers together
        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1;
    }

    public int getLength(ListNode head) {

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}