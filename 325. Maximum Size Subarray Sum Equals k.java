public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
<<<<<<< HEAD
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
=======
        // sum of subarray[j ~ i] = sum[0,j+1] - sum[0,i]
        int i = 0, cur = 0, ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        
        while( i < nums.length ){
            cur += nums[i];
            if(cur == k) ans = i + 1; //i only increment
            if(hm.containsKey(cur - k)) {ans = Math.max(ans, i - hm.get(cur - k));}
            if(!hm.containsKey(cur)) {hm.put(cur, i);}
            i++;
        }
        
        return ans;
>>>>>>> dfa8ce311054cb9a7def3330a52e2c2376ed8f32
    }
}