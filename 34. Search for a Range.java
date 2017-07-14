public class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        //find first element
        int i = 0;
        int j = nums.length - 1;
        int start = -1;
        int end = -1;
        boolean found = false;
        
        while(i <= j){
            int mid = i + (j - i)/2;
            
            if(nums[mid] < target){
                i = mid + 1;
            }
            else if(nums[mid] > target){
                j = mid - 1;
            }
            else{
                found = true;
                while(mid >= 0 && nums[mid] == target){
                    mid --;
                }
                start = mid + 1;
                mid ++;
                while(mid <= nums.length -1 && nums[mid] == target){
                    mid++;
                }
                end = mid -1;
                
                break;
            }
        }
        
        int[] ans = new int[]{start,end};
        
        return ans;
    }
}
