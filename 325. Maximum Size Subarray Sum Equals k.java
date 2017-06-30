public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
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
    }
}