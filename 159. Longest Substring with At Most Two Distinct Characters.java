class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        //Char and its number of occurrence
        
        int start = 0;
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            
            if (!hm.containsKey(cur)){
                hm.put(cur, 1);
            } else {
                hm.put(cur, hm.get(cur) + 1);
            }
            
            while (hm.size() > 2){
                char c = s.charAt(start);
                if (hm.get(c) > 1){  //Key
                    hm.put(c, hm.get(c) - 1);
                } else {
                    hm.remove(c);
                }
                start++;
            }

            ans = Math.max(ans, i - start + 1);
        }
        
        return ans;
    }
}
