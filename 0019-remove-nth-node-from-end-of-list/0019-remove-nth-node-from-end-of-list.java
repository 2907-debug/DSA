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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 0;
        ListNode temp = head;

        // ✅ Pehle total nodes count karo
        while (temp != null) {
            count++;
            temp = temp.next;
        }

      
        // Count nikalne ke baad hi check karo.
        if (count == n) {
            return head.next;
        }

        int distance = count - n;

        
        // Temp ko dobara head se start karna padega.
        temp = head;

        
        // distance - 1 steps chalo.
        for (int i = 1; i < distance; i++) {
            temp = temp.next;
        }

       
        // Link change karna hai.
        temp.next = temp.next.next;

        
        return head;
    }
}