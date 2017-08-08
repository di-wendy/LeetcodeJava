public class Solution {
    public String reverseStr(String s, int k) {
        
        StringBuilder sb = new StringBuilder();
        char[] letters = s.toCharArray();
        
        int i = 0;
        while(i*k < s.length()){
            if(i%2 == 0){
                for(int j = Math.min(s.length() - i*k, k); j > 0; j--){
                    sb.append(letters[j + i*k - 1]);
                }
            }
            else{
                for(int j = 0; j < k && i*k + j <s.length(); j++){
                    sb.append(letters[j + i*k]);
                }
            }
            i++;
        }
        
        return sb.toString();
    }
}