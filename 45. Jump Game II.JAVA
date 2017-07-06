//DP

public class Solution {
    public int jump(int[] nums) {
        
        if(nums.length == 0) return 0;
        
        int[] step = new int[nums.length];
        boolean[] check = new boolean[nums.length];
        
        step[0] = 0;
        check[0] = true;
        
        for(int i = 1; i < nums.length; i++){
            int cur = Integer.MAX_VALUE;
            check[i] = false;
            for(int j = i - 1; j >= 0; j --){
                if(check[j] == true && (i - j) <= nums[j] && step[j] < cur){
                    cur = Math.min(cur,step[j] + 1);
                    check[i] = true;
                }
            }
        step[i] = cur;   
        }
        
        return step[nums.length - 1];
    }
}

//DP
public class Solution {
    public int jump(int[] nums) {
        
        if(nums.length <= 1) return 0;

        int bound = 0;
        int access = nums[0];
        int step = 0;

        for(int i = 1; i < nums.length; i++){
            if(i > bound){
                step += 1;
                bound = access;
                if(bound >= nums.length - 1){
                    return step;
                }
            }
            access = Math.max(access,nums[i] + i);
        }
        
        return step;
    }
}