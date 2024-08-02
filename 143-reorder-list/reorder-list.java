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
    public void reorderList(ListNode head) {
        if(head.next == null){
            return;
        }
        ListNode mid = findMid(head);
        ListNode reversed = reverseRemainingList(mid);
        reorder(head,mid,reversed);

    }

    private ListNode findMid(ListNode head) {
        ListNode slow= head;
        ListNode fast = head.next;
        while(fast!= null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseRemainingList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }

    private void reorder(ListNode left, ListNode midPoint, ListNode right) {
        while (left != null && right != null && right != midPoint) {
            ListNode leftNext = left.next;
            ListNode rightNext = right.next;
            left.next = right;
            right.next = leftNext;
            left = leftNext;
            right = rightNext;
        }
    }
}