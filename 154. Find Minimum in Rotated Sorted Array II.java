class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0){
            return  -1;
        }    
        int lo = 0, hi = nums.length - 1;    
        while (lo + 1 < hi){
            int mid = lo + (hi - lo)/2;
            if (nums[mid] < nums[hi]){
                hi = mid;
            }
            else if (nums[mid] > nums[hi]){
                lo = mid;
            }
            else{
                hi --;
            }
        }
        return (nums[lo] <= nums[hi])?nums[lo]:nums[hi];
    }
}
