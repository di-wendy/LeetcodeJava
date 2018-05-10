/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class compareNode implements Comparator<ListNode>{
    public int compare(ListNode A, ListNode B){
        return A.val - B.val;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);

        ListNode p = dummy;
        Queue<ListNode> q = new PriorityQueue<ListNode>(new compareNode());

        for (int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                q.offer(lists[i]);
            }
        }

        //Complexity is O(nlongn), Space is O(n)
        while(q.size() > 0){
            ListNode cur = q.poll();
            p.next = new ListNode(cur.val);
            p = p.next;
            if (cur.next != null){
                q.offer(cur.next);
            }
        }

        return dummy.next;
    }
}