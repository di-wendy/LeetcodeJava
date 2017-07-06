public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
        int max = 0; 
        int sum = 0;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        //<sum, index>
        
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            if(sum == k) {max = i + 1;}
            else{
                if(hm.containsKey(sum - k)) {max = Math.max(max, i - hm.get(sum - k));} 
                //not always increase
            }
            if(!hm.containsKey(sum)) {hm.put(sum, i);} //The earliest requried value
        }
        
        return max;
    }
}