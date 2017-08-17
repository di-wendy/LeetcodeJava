public class LRUCache {
    
    private class Node{
        int key, val;
        Node pre, next;
        public Node (int key, int val){
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> hs = new HashMap<>();
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.pre = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if(!hs.containsKey(key)){
            return -1;
        }
        Node temp = hs.get(key);
        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;
        
        append(temp);
        
        return temp.val;
    }
    
    public void put(int key, int value) {
        if(get(key) != -1){
            hs.get(key).val = value;
            return;
        }
        
        if(hs.size() == capacity){
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
        
        Node insert = new Node(key, value);
        hs.put(key,insert);
        append(insert);
    }
    
    private void append(Node n){
        n.pre = tail.pre;
        tail.pre = n;
        n.pre.next = n;
        n.next = tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */