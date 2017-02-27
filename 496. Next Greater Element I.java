public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        
        if(findNums == null || nums == null) return findNums;
        
        HashMap <Integer,Integer> hm = new HashMap<Integer,Integer>();
        int[] ans = new int[findNums.length];
        
        for (int i=0; i<nums.length; i++){
            hm.put(nums[i],i);
        }
        
        for(int j=0; j<findNums.length; j++){
            int pos = hm.get(findNums[j])+1;
            while(pos<nums.length){
                if (nums[pos]>findNums[j]) break;
                pos ++;
            }
            if(pos == nums.length) ans[j] = -1;
            else ans[j] = nums[pos];
        }
        
        return ans;
        
    }
}
