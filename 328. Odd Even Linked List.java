/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null) return head;
        
        ListNode evenhead = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        
        while(odd!=null && odd.next!=null && even!=null && even.next!=null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenhead;
        
        return head;
    }
}
