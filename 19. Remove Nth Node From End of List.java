/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        int count = 0;

        while (fast != null){
            if (count > n){
                slow = slow.next;
            }
            fast = fast.next;
            count ++;
        }

        //remove slow.next
        slow.next = slow.next.next;

        return dummy.next;
    }
}