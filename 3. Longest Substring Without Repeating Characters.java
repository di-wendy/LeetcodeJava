public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap <Character,Integer> hm = new HashMap<Character,Integer> ();
        int res = 0;
        for (int i=0,j=0; i<s.length();++i){
            if (hm.containsKey(s.charAt(i))){
                //update j
                j  = Math.max(j,hm.get(s.charAt(i))+1);
            }
            hm.put(s.charAt(i),i);
            res = Math.max(res,i-j+1);
        }
        return res;
    }
}
