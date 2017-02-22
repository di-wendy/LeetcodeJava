public class Solution {
    public boolean canPermutePalindrome(String s) {
        
        if(s==null||s.length()<2) return true;
        
        Set<Character> hs = new HashSet<Character>();
        
        for(char a:s.toCharArray()){
            if(!hs.contains(a)) hs.add(a);
            else hs.remove(a);
        }
        
        return hs.size()==0 || hs.size()==1;
}
}
