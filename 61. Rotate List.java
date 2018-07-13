/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode totalhead = reverseLL(head);
        ListNode cur = totalhead;
        int i = 1;
        while (cur != null && cur.next != null){
            cur = cur.next;
            i++;
        }
        //System.out.print(i);
        k%=(i);
        cur = totalhead;
        if (k == 0) return reverseLL(totalhead);
        while (k > 1){
            cur = cur.next;
            k--;
        }
        ListNode tail = cur.next;
        cur.next = null;
        ListNode newHead = reverseLL(totalhead);
        totalhead.next = reverseLL(tail);
        return newHead;
    }
    
    public ListNode reverseLL(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode mark = head.next;
        ListNode newHead = reverseLL(head.next);
        mark.next = head;
        head.next = null;
        return newHead;
    }
}
