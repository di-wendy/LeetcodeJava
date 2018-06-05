/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode smallDummy = new ListNode(0);
        ListNode ans = smallDummy;
        ListNode bigDummy = new ListNode(0);
        ListNode bigHead = bigDummy;
        
        while (head != null){ //KEY
            if (head.val >= x){
                bigDummy.next = new ListNode(head.val);
                bigDummy = bigDummy.next;
            } else {
                smallDummy.next = new ListNode(head.val);
                smallDummy = smallDummy.next;
            }
            head = head.next;
        }
        
        smallDummy.next = bigHead.next;
        bigDummy.next = null;
        return ans.next;
    }
}
