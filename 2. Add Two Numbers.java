class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        int carry = 0;

        while(l1 != null || l2 != null){
            int sum = ((l1==null)?0:l1.val) + ((l2==null)?0:l2.val) + carry;
            carry = sum / 10;
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry != 0){
            dummy.next = new ListNode(carry);
        }

        return ans.next;
    }
}