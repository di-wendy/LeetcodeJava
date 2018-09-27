//
class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //Key distance, set<Integer> jump length can reach to key
        for (int n : stones){
            map.put(n, new HashSet<>());
        }
        //init
        map.get(1).add(1);
        
        for (int i = 1; i < stones.length; ++i){
            //To avoid concurrent error
            Set<Integer> set = new HashSet<>(map.get(stones[i])); 
            for (int jump : set){
                for (int delta = -1; delta <= 1; delta++){
                    int pos = stones[i] + jump + delta;
                    if (map.containsKey(pos)){
                        map.get(pos).add(jump + delta);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() != 0;
    }
}

//Basic Method
class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        //dp[i][k] boolean, ith stone, with last jump as k,
        boolean[][] dp = new boolean[stones.length][stones.length + 1];
        //init
        dp[0][0] = true;
        dp[1][1] = true;
        
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < stones.length; ++i){
            pos.put(stones[i], i);
        }
        
        for (int i = 2; i < stones.length; ++i){
            for (int j = i; j >= 1; j--){
                if (pos.containsKey(stones[i] - j)){
                    int index = pos.get(stones[i] - j);
                    if (dp[index][j + 1] || dp[index][j] || dp[index][j - 1]){
                        dp[i][j] = true;
                    }
                }
            }
        }
        for (int i = 0; i <= stones.length; ++i){
            if (dp[stones.length - 1][i]) return true;
        }
        
        return false;
    }
}
