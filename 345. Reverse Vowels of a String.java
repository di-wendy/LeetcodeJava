public class Solution {
    public String reverseVowels(String s) {
        
        if (s==null || s.length() == 0) return s;
        
        int i = 0;
        int j = s.length()-1;
        
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        
        while(i<j){
            while(i<j && !vowels.contains(chars[i]+"")){
                i++;
            }
            
            while(i<j && !vowels.contains(chars[j]+"")){
                j--;
            }
        
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            
            i++;
            j--;
        }
        
        return new String(chars);
    }
}
