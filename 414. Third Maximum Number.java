class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 0) return 0;
        long max = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long ans = Long.MIN_VALUE;
        
        int count = 0;
        
        for (int n : nums){
            if (n == max || n == secondMax || n == ans) continue;
            if (n > max){
                ans = secondMax;
                secondMax = max;
                max = n;
            } else if (n > secondMax){
                ans = secondMax;
                secondMax = n;
            } else if (n > ans){
                ans = n;
            }
            count++;
        }
        return (count >= 3) ? (int)ans : (int)max;
    }
}
