/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {


    public ListNode reverse(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode newTail = head.next;
        ListNode newHead = reverse(head.next);
        newTail.next = head;
        head.next = null;
        return newHead;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head;
        ListNode preslow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            preslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        preslow.next = null;
        ListNode tailChain = reverse(slow);

        ListNode p = head;
        //insert tailChian to p
        //1, 2, 3
        while (p != null){
            ListNode second = p.next;
            if (second != null) {
                p.next = tailChain;
                tailChain = tailChain.next;
                p.next.next = second;
                p = p.next.next;
            } else {
                p.next = tailChain;
                break;
            }

        }
    }
}
