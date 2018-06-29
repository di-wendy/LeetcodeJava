/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//
class Solution {
    public boolean isPalindrome(ListNode head) {
        //Find the middle node and reverse it
        ListNode slow = head;
        ListNode fast = head;
        ListNode preslow = null;
        while (fast != null && fast.next != null){
            preslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (preslow != null) preslow.next = null;
        
        ListNode middle = reverseLinkedList(slow);
        ListNode c = middle;
        
        while (head != null && middle != null){
            if (head.val != middle.val) return false;
            head = head.next;
            middle = middle.next;
        }
        return true;
    }
    
    public ListNode reverseLinkedList(ListNode Node){
        if (Node == null || Node.next == null) return Node;
        ListNode pre = null;
        while (Node != null){
            ListNode future = Node.next;
            Node.next = pre;
            pre = Node;
            Node = future;
        }
        return pre;
    }
}
//
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
