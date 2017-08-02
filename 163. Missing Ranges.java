public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> ans = new ArrayList<String>();
        
        for(int i = 0; i <= nums.length; i++){
            long lo = (i == 0)?lower:(long)nums[i-1] + 1;
            long hi = (i == nums.length)?upper:(long)nums[i] - 1;
            if (lo > hi){continue;}
            else if(lo == hi){
                ans.add(lo + "");
            }
            else{
                ans.add(lo + "->" + hi);
            }
        }
        
        return ans;
    }
}