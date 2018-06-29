class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Character, String> c2s = new HashMap<>();
        Map<String, Character> s2c = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++){
            if (c2s.containsKey(pattern.charAt(i))) {
                if (!c2s.get(pattern.charAt(i)).equals(words[i])) return false;
            } else if (s2c.containsKey(words[i])) return false;
            else {
                c2s.put(pattern.charAt(i), words[i]);
                s2c.put(words[i], pattern.charAt(i));
            }
        }
        return true;
    }
}
