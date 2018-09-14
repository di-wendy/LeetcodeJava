class Solution {
    LinkedList<String> ans;
    Map<String, PriorityQueue<String>> flight;
    public List<String> findItinerary(String[][] tickets) {
        ans = new LinkedList<String>();
        flight = new HashMap<>();
        for (String[] t : tickets){
            flight.computeIfAbsent(t[0], k -> new PriorityQueue<String>()).offer(t[1]);
        }
        dfs("JFK");
        return ans;
    }
    
    public void dfs(String s){
        PriorityQueue<String> des = flight.get(s);
        while (des != null && !des.isEmpty()){
            dfs(des.poll());   //NRT, KUL
        }
        ans.addFirst(s);
    }
}
