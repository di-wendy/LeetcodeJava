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

//Duplicate
class Solution {
    public int findDuplicate(int[] nums) {
        //min and maximum possible answer
        int start = 1;
        int end = nums.length - 1;

        while (start + 1 < end){
            int mid = (start + end)/2;
            if (countSmaller(nums, mid) > mid){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        //
        return (countSmaller(nums, start) <= start) ? end : start;
    }

    public int countSmaller(int[] nums, int mid){
        int count = 0;
        for (int n : nums){
            if (n <= mid){
                count ++;
            }
        }
        return count;
    }
}