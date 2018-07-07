class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++){
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (a, b) -> (b[0] - a[0]));
        String[] ans = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (i == 0) ans[pairs[i][1]] = "Gold Medal";
            else if (i == 1) ans[pairs[i][1]] = "Silver Medal";
            else if (i == 2) ans[pairs[i][1]] = "Bronze Medal";
            else ans[pairs[i][1]] = Integer.toString(i + 1);
        }
        return ans;
    }
}
