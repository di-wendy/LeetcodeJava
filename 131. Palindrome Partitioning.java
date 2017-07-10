public class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> ans = new ArrayList<>();
        
        helper(ans, new ArrayList<>(), s, 0);
        
        return ans;
    }
    
    public void helper(List<List<String>> ans, List<String> temp, String s, int pos){
        if(pos >= s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = pos; i < s.length(); i++){
            if( isPalindrome(s, pos, i)){
                temp.add(s.substring(pos, i + 1));
                helper(ans, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
        
    }
    
    public boolean isPalindrome(String s, int low, int high){
        
        while(low < high){
            if(s.charAt(low++) != s.charAt(high--)) return false;
        }
        
        return true;
    }
    
}