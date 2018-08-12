class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes.length == 0 || dislikes[0].length == 0) return true;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        //record group
        Map<Integer, Integer> g = new HashMap<>(); 
        
        for (int[] d : dislikes){
            map.putIfAbsent(d[0], new ArrayList<>());
            map.putIfAbsent(d[1], new ArrayList<>());
            map.get(d[0]).add(d[1]);
            map.get(d[1]).add(d[0]);
        }
        
        for (int i = 1; i <= N; i++){
            if (!g.containsKey(i) && !search(i, 0, map, g)){
                return false;
            }
        }
        return true;
    }
    
    public boolean search(int i, int group, Map<Integer, ArrayList<Integer>> map, 
                          Map<Integer, Integer> g){
        if (g.containsKey(i)) return g.get(i) == group;
        g.put(i, group);
        if (map.containsKey(i)){
            for (int nei : map.get(i)){
            if(!search(nei, group^1, map, g)) return false;
            }
        }
        return true;
    }
}
