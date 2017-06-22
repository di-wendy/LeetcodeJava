//Own 33%
public class Solution {
    public boolean detectCapitalUse(String word) {
        
        boolean ans = true;
        
        if(word.length() <= 1) return ans;
        
        char[] letters = word.toCharArray();
        
        if(Character.isUpperCase(word.charAt(0))){
            if(Character.isUpperCase(word.charAt(1))){
                for(int i = 2; i < word.length(); i++){
                    if(!Character.isUpperCase(word.charAt(i))){
                        return false;
                        }
                    }
                }
            else{
                for(int i = 2; i < word.length(); i++){
                    if(Character.isUpperCase(word.charAt(i))){
                        return false;
                    }
                }
            }
        }
        else{
            for(int i = 1; i < word.length(); i++){
                if(Character.isUpperCase(word.charAt(i))){
                    return false;
                }
            }
        }
        return ans;
    }
}
//
    public boolean detectCapitalUse(String word) {
        return word.equals(word.toUpperCase()) || 
               word.equals(word.toLowerCase()) ||
               Character.isUpperCase(word.charAt(0)) && 
               word.substring(1).equals(word.substring(1).toLowerCase());
    }
