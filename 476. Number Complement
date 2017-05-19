//28%
public class Solution {
    public int findComplement(int num) {
        
         String binaryIntStr = Integer.toBinaryString(num);
         char[] charArray = binaryIntStr.toCharArray();
         
         for(int i = 0; i < charArray.length; i++){
             charArray[i] = (charArray[i]=='0')?'1':'0';
         }
         
         String binary = new String(charArray);
         
         int ans = Integer.parseInt(binary,2);
         
         return ans;
    }
}

//Smart Method
public class Solution {
    public int findComplement(int num) {
        
         int i = 0;
         int j = 0;
         
         while(i < num){
             i += Math.pow(2,j);
             j++;
         }
         
         return (i-num);
    }
}
