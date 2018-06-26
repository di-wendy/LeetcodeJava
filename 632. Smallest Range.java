class Node{
    int i, j, val;
    public Node(int i, int j, int val){
        this.i = i;
        this.j = j;
        this.val = val;
    }
}

public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int res = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int curmax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        
        //Put Element in PQ
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for (int i = 0; i < nums.size(); i++){
            pq.offer(new Node(i, 0, nums.get(i).get(0)));
            curmax = Math.max(curmax, nums.get(i).get(0));
        }
        min = pq.peek().val;
        max = curmax;
        res = (curmax - min);
        
        while(true){
            Node cur = pq.poll();
            if (cur.j == nums.get(cur.i).size() - 1) break;
            pq.offer(new Node(cur.i, cur.j + 1, nums.get(cur.i).get(cur.j + 1)));
            curmax = Math.max(curmax, nums.get(cur.i).get(cur.j + 1));
            if (curmax - pq.peek().val < res){
                max = curmax;
                min = pq.peek().val;
                res = max - min;
            }
        }
        
        return new int[]{min,max};
    }
}
