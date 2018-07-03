class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            int mid = (i + j)/2;
            if (mid % 2 == 1) mid--; //mid is even number
            if (nums[mid] != nums[mid + 1]) j = mid;
            else i = mid + 2;
        }
        return nums[i];
    }
}
//Update
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        
        if(nums[i] != nums[i+1]) return nums[0];
        if(nums[j] != nums[j-1]) return nums[j];
        
        while(i < j){
            int mid = i + (j - i)/2;
            int temp = 0;
            if(nums[mid] == nums[mid + 1]) temp = mid + 1;
            if(nums[mid] == nums[mid - 1]) temp = mid;
            if(nums[mid] != nums[mid + 1] && nums[mid] != nums[mid -1]) return nums[mid];
            
            if(temp % 2 == 1) i = mid;
            if(temp % 2 == 0) j = mid;
        }
        
        if(nums[i] != nums[i + 1] && nums[i] != nums[i -1]) return nums[i];
        return nums[j];
    }
}
