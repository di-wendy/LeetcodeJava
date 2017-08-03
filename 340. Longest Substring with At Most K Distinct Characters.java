public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        int[] element = new int[256];
        int i = 0;
        int j = 0;
        
        String res = "";
        
        while(i < s.length()){
            while(j < s.length() && isDistinct(element,k)){
                element[s.charAt(j)] ++;
                j ++;
            }
            int end = (j == s.length() && isDistinct(element,k))?s.length():j - 1;
            if(end - i > res.length()){
                res = s.substring(i, end);
            }
            if(j == s.length()) break;
            element[s.charAt(i)]--;
            i++;
        }
        return res.length();
    }
    
    public boolean isDistinct(int[] element, int max){
        int ans = 0;
        for(int n:element){
            if(n > 0)
                ans++;
        }
        return (ans <= max);
    }
}
