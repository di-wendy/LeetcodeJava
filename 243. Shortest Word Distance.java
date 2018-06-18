class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, Integer> map = new HashMap<>();
        int dis = words.length;
        for (int i = 0; i < words.length; i++){
            if (words[i].equals(word1)){
                map.put(word1, i);
                if (!map.containsKey(word2)) continue;
                else dis = Math.min(dis, i - map.get(word2));
            }
            if (words[i].equals(word2)){
                map.put(word2, i);
                if (!map.containsKey(word1)) continue;
                else dis = Math.min(dis, i - map.get(word1));
            }
        }
        return dis;
    }
}
