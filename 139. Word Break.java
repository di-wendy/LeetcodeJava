public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        //Dynamic Programming
        boolean[] store = new boolean[s.length() + 1];
        
        store[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(store[j] && wordDict.contains(s.substring(j,i))){
                    store[i] = true;
                }
            }
        }
        
        return store[store.length - 1];
        
    }
}
