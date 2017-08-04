public class Solution {
    public int findIntegers(int num) {
        
        int count = 0;
        
        for(int i = 0; i <= num; i ++){
            int pre = 0;
            for(int j = 0; j < 32; j++){
                int cur = i>>j & 1;
                if(pre == 1 && cur == 1)
                    break;
                pre = cur;
                if(j == 31) count++;
            }
        }
        
        return count;
    } 
}
