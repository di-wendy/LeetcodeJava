/*Frist, we take the first k elements of nums1 and paired with nums2[0] as the starting pairs so that we have (0,0), (1,0), (2,0),.....(k-1,0) in the heap.
Each time after we pick the pair with min sum, we put the new pair with the second index +1. ie, pick (0,0), we put back (0,1). Therefore, the heap alway maintains at most min(k, len(nums1)) elements.*/

public class Solution {
    class Pair{
        int[] pair;
        int idx; // current index to nums2
        long sum;
        Pair(int idx, int n1, int n2){
            this.idx = idx;
            pair = new int[]{n1, n2};
            sum = (long) n1 + (long) n2;
        }
    }
    class CompPair implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2){
            return Long.compare(p1.sum, p2.sum);
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<>();
        if (nums1==null || nums2==null || nums1.length ==0 || nums2.length ==0) return ret;
        int len1 = nums1.length, len2=nums2.length;  

        PriorityQueue<Pair> q = new PriorityQueue(k, new CompPair()); 
        for (int i=0; i<nums1.length && i<k ; i++) { // only need first k number in nums1 to start  
            q.offer( new Pair(0, nums1[i],nums2[0]) );
        }
        for (int i=1; i<=k && !q.isEmpty(); i++) { // get the first k sums
            Pair p = q.poll(); 
            ret.add( p.pair );
            if (p.idx < len2 -1 ) { // get to next value in nums2
                int next = p.idx+1;
                q.offer( new Pair(next, p.pair[0], nums2[next]) );
            }
        }
        return ret;
    }
}
//
public class Solution {
    class Pair{
        public int a;
        public int b;
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    class PairCompare implements Comparator<Pair>{
        public int compare(Pair A, Pair B){
            return (A.a + A.b - B.a - B.b);
        }
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new PairCompare());
        
        for(int n: nums1){
            for(int m: nums2){
                pq.offer(new Pair(n,m));
            }
        }
        
        List<int[]> res = new ArrayList<>();
        
        int i = 0;
        while(i < Math.min(k, nums1.length * nums2.length)){
            Pair elem = pq.poll();
            res.add(new int[]{elem.a,elem.b});
            i++;
        }
        
        return res;
    }
}
