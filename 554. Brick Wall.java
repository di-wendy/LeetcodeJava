class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int max = wall.size();
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int i = 0; i < max; i++){
            int cur = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++){
                cur += wall.get(i).get(j);
                freq.put(cur, freq.getOrDefault(cur, 0) + 1);
            }
        }
        
        //Put into Priority Queue to sort
        PriorityQueue<Map.Entry<Integer, Integer>> sortFreq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> A, Map.Entry<Integer, Integer> B){
                return (A.getValue() > B.getValue()) ? -1 : 1; //From Big to Small
            }
        });
        
        for (Map.Entry<Integer, Integer> element : freq.entrySet()){
            sortFreq.offer(element);
        }
        
        return sortFreq.size() == 0 ? max : max - sortFreq.poll().getValue();
    }
}
