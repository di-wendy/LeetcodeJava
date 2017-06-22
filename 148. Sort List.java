/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) return head; //Unit
        
        ListNode brk = head, start = head, end = head;
        while(end != null && end.next != null){
            brk = start;
            start = start.next;
            end = end.next.next;
        }
        brk.next = null; //break the two links
        ListNode p1 = sortList(head);
        ListNode p2 = sortList(start);
        
        return mergelist(p1,p2);
    }
    
    public ListNode mergelist(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val){
            l1.next = mergelist(l1.next, l2);
            return l1;
        }
        if(l1.val > l2.val){
            l2.next = mergelist(l2.next, l1);
            return l2;
        }
        return l1;
    }
}
