class Solution {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Boolean> group = new HashMap<>();
        //if (graph.length == 0 || graph[0].length == 0) return true;
        //Put relationships into map
        for (int i = 0; i < graph.length; i++){
            map.put(i, new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++){
                map.get(i).add(graph[i][j]);
            }
        }
        //DFS the graph
        for (int i = 0; i < graph.length; i++){
            if (!group.containsKey(i) && !classify(i, true, map, group)){
                return false;
            }
        }
        return true;
    }
    
    public boolean classify(int i, boolean inGroup, Map<Integer, List<Integer>> map, 
                            Map<Integer, Boolean> group){
        if (group.containsKey(i)) return group.get(i) == inGroup;
        group.put(i, inGroup);
        for (int n : map.get(i)){
            if (!classify(n, !inGroup, map, group)) return false;
        }
        return true;
    }
}
