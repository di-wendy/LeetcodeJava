public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int i = 0;
        int max = 0;
        
        if (nums.length==0){return count;}
        
        while (i < nums.length){
            if (nums[i] == 1){
                count += 1;
            }
            else{
                if (count > max){
                    max = count;
                }
                count = 0; 
            }
            i++;
        }
        if (count > max){max = count;}
        
        return max;
        
    }
}
