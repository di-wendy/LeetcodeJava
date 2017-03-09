//StringBuilder ans = new StringBuilder();

//46%
public class Solution {
    public String convert(String s, int numRows) {
        
        //Builder n line of String Builder
        
        StringBuilder[] ans = new StringBuilder[numRows];
        char[] letters = s.toCharArray();
        
        for(int i=0; i<numRows; i++) {ans[i] = new StringBuilder();}
        
        int i = 0;
        while(i < s.length()){
            
            for(int row = 0; row < numRows && i<s.length(); row++){
                ans[row].append(letters[i++]);
            }
            
            for(int row = numRows - 2; row >=1 && i<s.length(); row--){
                ans[row].append(letters[i++]);
            }
        }
        
        for(int k = 1; k < numRows; k++){
            ans[0].append(ans[k]);
        }
        
        return ans[0].toString();
    }
}
