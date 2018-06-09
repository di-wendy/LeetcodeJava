class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxlen = 0;
        int minlen = Integer.MAX_VALUE;
        Set<String> dict = new HashSet<String>();
        for (int i = 0; i < wordDict.size(); i++){
            dict.add(wordDict.get(i));
            maxlen = Math.max(maxlen, wordDict.get(i).length());
            minlen = Math.min(minlen, wordDict.get(i).length());
        }
        boolean[] test = new boolean[s.length() + 1];
        //...ith letter is a word break or not
        test[0] = true;
        for (int i = 1; i <= s.length(); i++){
            int len = minlen;
            while (i - len >= 0 && len <= maxlen && test[i] == false){
                if (test[i - len] && dict.contains(s.substring(i - len, i))){
                    test[i] = true;
                } else {
                    len++;
                }
            }
        }
        return test[s.length()];
    }
}
