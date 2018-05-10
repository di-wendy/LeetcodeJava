class Solution {
    public ListNode swapPairs(ListNode head) {
        //three pointer
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        head = dummy;
        while (head.next != null && head.next.next != null){
            ListNode l = head.next;
            ListNode r = head.next.next;
            
            l.next = r.next;
            r.next = l;
            head.next = r;
            
            head = l;
        }
        
        return dummy.next;
    }
}
