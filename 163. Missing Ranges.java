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

//Another method
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            ans.add(convertRange(lower, upper));
            return ans;
        }
        if (lower < nums[0]) ans.add(convertRange(lower, nums[0] - 1));
        for (int i = 0; i < nums.length - 1; i++){
            long diff = (long)nums[i + 1] - (long)nums[i];
            if (diff <= 1) continue;
            ans.add(convertRange(nums[i] + 1, nums[i + 1] - 1));
        }
        if (nums[nums.length - 1] < upper){
            ans.add(convertRange(nums[nums.length - 1] + 1, upper));
        }
        return ans;
    }
    
    public String convertRange(int i, int j){
        //inclusive range
        if (i == j) return Integer.toString(i);
        return Integer.toString(i) + "->" + Integer.toString(j);
    }
}
