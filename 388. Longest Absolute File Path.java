public class Solution {
    public int lengthLongestPath(String input) {
        
        int ans = 0;
        if(input.length() == 0) return ans;
        
        int[] path = new int[input.length() + 2];
        
        for(String s: input.split("\n")){
            int level = s.lastIndexOf("\t") + 1;
            path[level + 1] =  path[level] + s.substring(level).length() + 1;
            
            if(s.indexOf(".") != -1){
                ans = Math.max(ans, path[level + 1] - 1);
            }
        }
        
        
        return ans;
    }
}
