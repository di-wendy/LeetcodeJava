public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int fast = 1;
        int slow = 1;
        int counter = nums[0];
        int count = 1;
        while (fast < nums.length){
            if (nums[fast] == counter){
                count ++;
            }
            else{
                counter = nums[fast];
                count = 1;
            }
            nums[slow] = nums[fast];
            if (count <= 2){
                slow ++;
            }
            fast ++;
        }
        return slow;
    }
}
