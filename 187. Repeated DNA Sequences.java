class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> seenAgain = new HashSet<>();
        
        for (int i = 0; i <= s.length() - 10; i++){
            String temp = s.substring(i, i + 10);
            if (seen.contains(temp)) seenAgain.add(temp);
            seen.add(temp);
        }

        return new ArrayList<String>(seenAgain);
    }
}
