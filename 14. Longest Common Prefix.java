//94.8%
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String ans = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(ans)!=0){
                ans = ans.substring(0,ans.length()-1);
            }
            i++;
        }
        
        return ans;
    }
}
