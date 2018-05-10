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

//
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        
        if (nums.length < 1){
            return ans;
        }
        
        int l = 0;
        int r = nums.length - 1;
        
        while (l + 1 < r){
            int mid = (l + r) / 2;
            if (nums[mid] == target){
                l = mid;
                r = mid;
                break;
            }
            else if (nums[mid] < target){
                l = mid;
            }
            else{
                r = mid;
            }
        }
        
        if (nums[l] != target && nums[r] != target){
            return ans;
        }
        
        int p = (nums[l] == target) ? l : r;
        int q = (nums[r] == target) ? r : l;
        
        while (p >= 0 && nums[p] == target){
            p--;
        }
        ans[0] = p + 1;
        
        while (q < nums.length && nums[q] == target){
            q++;
        }
        ans[1] = q - 1;
        
        return ans;
    }
}
