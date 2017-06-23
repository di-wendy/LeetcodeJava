/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        if(head == null) return null;
        
        Map<RandomListNode,RandomListNode> hm = new HashMap<RandomListNode,RandomListNode>();
        
        RandomListNode node = head;
        //copy the nodes into the hashmap
        while(node != null){
            hm.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        
        node = head;
        //copy their relationships
        while(node != null){
            hm.get(node).next = hm.get(node.next);
            hm.get(node).random = hm.get(node.random);
            node = node.next;
        }
        
        return hm.get(head);
    }
}
