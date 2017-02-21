/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
//Iteratively
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head ==null || head.next ==null) return head;
        
        //Initilization
        ListNode pointer = head.next; //3
        ListNode record = head.next.next;//4
        pointer.next = head;//3->1
        head.next = null; //1->null
        
        //Invariant
        while(record !=null){
            ListNode temp = pointer; //3
            pointer = record; //4
            record = record.next; //5
            pointer.next = temp;//4->3,set link at the end
        }
        
        return pointer;
    }
}

//Recursively
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }
}
