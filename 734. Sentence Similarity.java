class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> similar = new HashMap<>();
        for (String[] pair : pairs){
            similar.putIfAbsent(pair[0], new HashSet<>());
            similar.putIfAbsent(pair[1], new HashSet<>());
            similar.get(pair[0]).add(pair[1]);
            similar.get(pair[1]).add(pair[0]);
        }
        
        for (int i = 0; i < words1.length; i++){
            if (words1[i].equals(words2[i])) continue;
            if (!similar.containsKey(words1[i])) return false;
            if (similar.get(words1[i]).contains(words2[i])) continue;
            else return false;
        }
        return true;
    }
}
