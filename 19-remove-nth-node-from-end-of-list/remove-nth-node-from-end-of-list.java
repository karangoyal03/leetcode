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
        if(head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
     for (int count = 0; count < n; count++) {
        fast = fast.next;
    }
    if (fast == null) {
        return head.next;
    }

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        if(slow.next!=null) {
        slow.next = slow.next.next;
        }

        return head;
    }
}