//Bucket First Solution
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int n:nums){
            if(!hm.containsKey(n)){
                hm.put(n,1);
            }
            else{
                hm.put(n,hm.get(n)+1);
            }
        }
        
        //Dump numbers in List Array Bucket, O(n)
        List<Integer>[] store = new List[nums.length + 1];
        for(int value:hm.keySet()){
            int freq = hm.get(value);
            if(store[freq] == null){
                store[freq] = new ArrayList<Integer>();
            }
            store[freq].add(value);
        }
        
        //Build ans
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = nums.length; i >=0; i --){
            if(store[i] != null){
                ans.addAll(store[i]);
            }
            if(ans.size() >= k){
                break;
            }
        }
        
        return ans;
    }
}

//Bucket 92.55%
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        //Store Frequency in Map, O(n)
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>(); //<value,freq>
        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num, 0)+1);
        }
        
        //Dump numbers in List Array Bucket, O(n)
        List<Integer>[] Bucket = new List[nums.length];
        for(int value:freqMap.keySet()){
            int freq = freqMap.get(value);
            if(Bucket[freq-1] == null){
                Bucket[freq-1] = new ArrayList<Integer>();
            }
            Bucket[freq-1].add(value);
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = nums.length - 1; ans.size()<k; i--){
            if(Bucket[i] != null){
                ans.addAll(Bucket[i]);
            }
        }
        
        return ans;
        
    }
}

//Priority Queue
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        //HashMap to store <number,frequency>
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

        for(int n:nums){
            if(hm.containsKey(n)){
                hm.put(n,hm.get(n)+1);
            }
            else{
                hm.put(n,1);
            }
        }

        //Use Priority Queue to store Map.entry, arranged by frequency
        PriorityQueue<Map.Entry<Integer,Integer>> pq =
        new PriorityQueue<Map.Entry<Integer,Integer>>(new Comparator<Map.Entry<Integer,Integer>>()
         {
            @Override
            public int compare(Map.Entry<Integer,Integer> element1,Map.Entry<Integer,Integer> element2) {
                int ans = element2.getValue() - element1.getValue();
                return ans;
            }
         });

        //Put element into Queue
        for(Map.Entry<Integer,Integer> element: hm.entrySet()){
            pq.offer(element);
        }

        //Output the first k element in Priority queue
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < k; i++){
            Map.Entry<Integer,Integer> element = pq.poll();
            ans.add(element.getKey());
        }
        return ans;
        
    }
}
