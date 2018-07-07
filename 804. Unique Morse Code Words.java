class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] moose = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",
                                      ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
                                      "...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> ans = new HashSet<>();
        for (String word : words){
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()){
                sb.append(moose[c - 'a']);
            }
            String cur = sb.toString();
            if (!ans.contains(cur)) ans.add(cur);
        }
        return ans.size();
    }
}
