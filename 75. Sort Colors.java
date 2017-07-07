//Simple One Pass
public class Solution {
    public void sortColors(int[] nums) {
        //Counting Sort
        int cnt_0 = 0;
        int cnt_1 = 0;
        int cnt_2 = 0;
        
        for(int n:nums){
            if(n==0){
                cnt_0 ++;
            }
            else if(n==1){
                cnt_1 ++;
            }
            else if(n==2){
                cnt_2 ++;
            }
        }
        
        for(int i=0; i<nums.length; i++){
            if(i< cnt_0){
                nums[i] = 0;
            }
            else if(i>= cnt_0 && i< cnt_0 + cnt_1){
                nums[i] = 1;
            }
            else{
                nums[i] = 2;
            }
        }
        
    }
}

//
