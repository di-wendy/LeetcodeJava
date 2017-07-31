/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null) return true;
        
        ListNode s = head;
        ListNode f = head;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        
        ListNode right = null;
        if(f != null){
            right = reverse(s.next);
        }
        else{
            right = reverse(s);
        }
        
        while(right != null){
            if(right.val != head.val){
                return false;
            }
            right = right.next;
            head = head.next;
        }

        return true;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}