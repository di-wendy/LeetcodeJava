class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo + 1 < hi){
            int mid = lo + (hi - lo)/2;
            if (nums[mid] < mid + 1){
                hi = mid;
            }
            else{
                lo = mid;
            }
        }
        
        return nums[lo];
    }
}
