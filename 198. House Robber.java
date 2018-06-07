public class Solution {
    public int rob(int[] nums) {
        int pre = 0;
        int val = 0;
        
        for(int n:nums){
            int temp = val;
            val = Math.max(val, pre + n);
            pre = temp;
        }
        
        return val;
    }
}

//Easier to understand
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        //init
        int notRob = 0;
        int Robbed = nums[0];
        //update
        for (int i = 1; i < nums.length; i++){
            int temp = notRob;
            notRob = Math.max(notRob, Robbed); //not rob current, can take either pre
            Robbed = temp + nums[i]; //rob current, can only take not rob pre
        }
        return Math.max(notRob, Robbed);
    }
}
