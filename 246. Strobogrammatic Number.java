public class Solution {
    public boolean isStrobogrammatic(String num) {
        
        HashMap <Character,Character> dic = new HashMap <Character,Character> ();
        
        dic.put('8','8');
        dic.put('6','9');
        dic.put('9','6');
        dic.put('1','1');
        dic.put('0','0');
        
        int i = 0;
        int j = num.length()-1;
        
        while(i<=j){
            if (!dic.containsKey(num.charAt(i))){
                return false;
            } 
            
            if (dic.get(num.charAt(i))!=num.charAt(j)){
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}
//Concise Solution 60%
public class Solution {
    public boolean isStrobogrammatic(String num) {
        
        for(int i = 0,j = num.length()-1; i <=j; i++, j--){
            if(!"00 11 88 696".contains(num.charAt(i)+""+num.charAt(j))){
                return false;
            }
        }

        return true;
    }
}