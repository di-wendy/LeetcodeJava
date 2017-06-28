public class Solution {
    public int search(int[] nums, int target) {
        
        if(nums.length < 1) return -1;
        int start = 0, end = nums.length - 1;
        
        int s = nums[0];
        int e = nums[nums.length - 1];
        
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(s < nums[mid]){
                if(nums[mid] > target && target >= s){
                    end = mid;
                }
                else{
                    start = mid;
                }
            }else{
                if(nums[mid] < target && target <= e){
                    start = mid;
                }
                else{
                    end = mid;
                }
            }
        }
        
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }
}
