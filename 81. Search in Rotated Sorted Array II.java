class Solution {
    public boolean search(int[] nums, int target) {
        
        int start  = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target) return true;
            
            if (nums[mid] > nums[start]){
                if (target < nums[start] || target > nums[mid]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            else if (nums[mid] < nums[start]){
                if (target < nums[mid] || target > nums[end]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                start ++;
            }
        }
        return false;
    }
}
