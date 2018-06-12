class Solution {
    public int majorityElement(int[] nums) {
        //Boyer Moore Algorithm
        //Another method is Sorting and take n/2
        int count = 0;
        int ans = nums[0];
        for (int n : nums){
            if (count == 0) {
                ans = n;
                count += 1;
            } else {
                if (n == ans) count++;
                else count--;
            }
        }
        return ans;
    }
}
