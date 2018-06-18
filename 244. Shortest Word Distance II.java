class WordDistance {
    Map<String, Set<Integer>> map;
    public WordDistance(String[] input) {
        map = new HashMap<>();
        for (int i = 0; i < input.length; i++){
            if (!map.containsKey(input[i])) map.put(input[i], new HashSet<>());
            map.get(input[i]).add(i);
        }
    }
    
    public int shortest(String a, String b) {
        Set<Integer> indexA = map.get(a);
        Set<Integer> indexB = map.get(b);
        int diff = Integer.MAX_VALUE;
        for (int i : indexA){
            for (int j : indexB){
                if (Math.abs(j - i) < diff){
                    diff = Math.abs(j - i);
                }
            }
        }
        return diff;        
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
