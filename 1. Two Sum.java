//Hashmap 8ms

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap <Integer,Integer> hm = new HashMap <Integer,Integer>();
        int[] ans = new int[2];
        int index = 0;
        
        for(int i: nums){
            int t = target - i;
            if (!hm.containsKey(t)) hm.put(i,index);
            else {
                ans[0] = hm.get(t);
                ans[1] = index;
                return ans;
            }
            index ++;
        }
        return ans;
    }
}

//
