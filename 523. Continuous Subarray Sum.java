class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1) return false;
        
        //Get sum array
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        sums[1] = nums[0];
        for (int i = 2; i <= nums.length; i++){
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        
        //O(n^2) Complexity
        for (int i = 2; i <= nums.length; i++){
            for (int j = i - 2; j >= 0; j--){
                if (k == 0) {
                    if (sums[i] - sums[j] == 0){
                        return true;
                    }
                }
                else{
                    if ((sums[i] - sums[j]) % k == 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

//Understanding of MOD
public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
    int runningSum = 0;
    for (int i=0;i<nums.length;i++) {
        runningSum += nums[i];
        if (k != 0) runningSum %= k; 
        Integer prev = map.get(runningSum);
        if (prev != null) {
            if (i - prev > 1) return true;
        }
        else map.put(runningSum, i);
    }
    return false;
}
