public class Solution {
    public int arrangeCoins(int n) {
        
        
        int row = 0;
        int num = 1;
        
        while(n > 0){
            n -= (num);
            num += 1;
            row ++;
        }
        
        return (n<0)?--row:row;
        
        
    }
}