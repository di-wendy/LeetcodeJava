class Solution {
    public int[] singleNumber(int[] input) {
        int diff = 0;
        int[] output = new int[]{0,0};
        for (int n : input) diff ^= n;
        diff &= -diff;
        for (int n : input){
            if ((n&diff) == 0){
                output[0] ^= n;
            } else {
                output[1] ^= n;
            }
        }
        return output;
    }
}
//Simplier
public class Solution {
    public int[] singleNumber(int[] nums) {
        
        //Xor all numbers
        int sum = 0;
        int[] ans = new int[2];
        
        for(int n:nums){
            sum ^= n;
        }
        
        //n is something 010101;
        int diffbit = 0;
        for(int i = 0; i < 32; i++){
            int temp = sum >> i & 1;
            if(temp > 0){
                diffbit = i;
                break;
            }
        }
        
        //Divide nums into two array
        int res1 = 0,res2 = 0;
        for(int n:nums){
            if((n >> diffbit & 1) == 1){
                res1 ^= n;
            }
            else{
                res2 ^= n;
            }
        }
        
        ans[0] = res1;
        ans[1] = res2;
        
        return ans;
        
    }
}
