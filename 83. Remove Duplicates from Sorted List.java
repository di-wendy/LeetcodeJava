/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null){
            if (slow.val != fast.val){
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            } else {
                fast = fast.next;
            }
        }
        slow.next = fast;
        return head;
    }
}
