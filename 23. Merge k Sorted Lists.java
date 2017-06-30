/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode> (){
        public int compare(ListNode a, ListNode b){
            if(a == null) return 1; //true
            if(b == null) return -1;
            return a.val - b.val;
        }
    };
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
        
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                heap.add(lists[i]); //avoid add null
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while(!heap.isEmpty()){
            ListNode head = heap.poll(); //Take out the min value
            tail.next = head;
            tail = head;
            if(head.next != null){
                heap.add(head.next);
            }
        }
        
        return dummy.next;
    }
}\