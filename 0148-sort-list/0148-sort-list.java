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

    public ListNode sortList(ListNode head) {

        
        if (head == null || head.next == null) {
            return head;
        }

        // Middle find karo
        ListNode middle = findMiddle(head);

        // Right half ka head save karo
        ListNode rightHead = middle.next;

        // List ko 2 parts me tod do
        middle.next = null;

        // Left half sort karo
        ListNode left = sortList(head);

        // Right half sort karo
        ListNode right = sortList(rightHead);

        // Dono sorted lists merge karo
        return merge(left, right);
    }

    public ListNode findMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Middle return karo
        return slow;
    }

    public ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

       
        while (left != null && right != null) {

            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }

           
            tail = tail.next;
        }

        // Agar left list bachi hai
        if (left != null) {
            tail.next = left;
        }

        
        if (right != null) {
            tail.next = right;
        }

        
        return dummy.next;
    }
}