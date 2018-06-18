class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, Integer> map = new HashMap<>();
        int dis = words.length;
        for (int i = 0; i < words.length; i++){
            if (words[i].equals(word1)){
                if (map.containsKey(word2)) dis = Math.min(dis, i - map.get(word2));
                map.put(word1, i);
            } else if (words[i].equals(word2)){
                if (map.containsKey(word1))dis = Math.min(dis, i - map.get(word1));
                map.put(word2, i);
            }
        }
        return dis;
    }
}
