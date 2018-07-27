/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode newHead = reverse(head); //3->2->1
        int carry = 1;
        
        ListNode cur = newHead;
        while (cur != null){
            int temp = carry;
            carry = (cur.val + carry)/10;
            cur.val = (cur.val + temp)%10;
            if (carry == 0) break;
            cur = cur.next;
        }
        if (carry!=0) {
            head.next = new ListNode(1);
            head = head.next;
        }
        return reverse(newHead);
    }
    
    public ListNode reverse(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode tail = head.next;
        ListNode newHead = reverse(head.next);
        tail.next = head;
        head.next = null;
        return newHead;
    }
}
