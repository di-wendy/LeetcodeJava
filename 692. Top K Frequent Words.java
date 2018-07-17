class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //HashMap to store <word,frequency>
        HashMap<String,Integer> hm = new HashMap<>();
        for (String s : words) hm.put(s, hm.getOrDefault(s, 0) + 1);
        
        PriorityQueue<Map.Entry<String, Integer>> pq =
        new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String,Integer> A, Map.Entry<String,Integer> B){
                if (A.getValue() != B.getValue()){
                    return A.getValue() > B.getValue() ? -1 : 1;
                } else {
                    return A.getKey().compareTo(B.getKey());
                }
            }
        });
        for (Map.Entry<String,Integer> e: hm.entrySet()) pq.offer(e);
        //Put ans in List<String>
        List<String> ans = new ArrayList<String>();
        while (ans.size() < k){
            ans.add(pq.poll().getKey());
        }
        return ans;
    }
}
