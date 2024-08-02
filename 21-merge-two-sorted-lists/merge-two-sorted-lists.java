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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode temp = ans;
        
        ListNode leftOfList1 = list1;
        ListNode leftOfList2 = list2;

        while(leftOfList1!=null && leftOfList2 !=null) {
             ListNode newNode = new ListNode();
            if(leftOfList1.val<=leftOfList2.val){
                newNode.val = leftOfList1.val;
                leftOfList1 = leftOfList1.next;     
            }else if(leftOfList2.val<=leftOfList1.val){
                newNode.val = leftOfList2.val;
                leftOfList2 = leftOfList2.next;
            }
            newNode.next = null;
            temp.next = newNode;
            temp = temp.next;
        }

        if(leftOfList1 == null && leftOfList2!=null){
            while(leftOfList2!=null) {
                 ListNode newNode = new ListNode();
                  newNode.val = leftOfList2.val;
                    leftOfList2 = leftOfList2.next;
                        newNode.next = null;
                    temp.next = newNode;
                    temp = temp.next;
            }
        }

        if(leftOfList2 == null && leftOfList1!=null) {
            while(leftOfList1!=null) {
                 ListNode newNode = new ListNode();
                  newNode.val = leftOfList1.val;
                    leftOfList1 = leftOfList1.next;
                        newNode.next = null;
                    temp.next = newNode;
                    temp = temp.next;

            }
        }

        return ans.next;
    }
}