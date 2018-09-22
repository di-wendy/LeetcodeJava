class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] len = new int[nums.length]; 
        //length of longest subsequence ended at i
        Arrays.fill(len, 1);
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        //count of longest subsequence ended at i
        for (int i = 0; i < nums.length; ++i){
            for (int j = 0; j < i; ++j){
                if (nums[i] > nums[j]){
                    if (len[j] >= len[i]){
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    } else if (len[j] + 1 == len[i]){
                        count[i] += count[j];
                    }
                }
            }
        }
        int longest = 0;
        int ans = 0;
        for (int n : len) longest = Math.max(longest, n);
        for (int i = 0; i < count.length; i++){
            if (len[i] == longest) ans += count[i];
        }
        return ans;
    }
}
